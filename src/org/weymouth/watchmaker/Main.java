package org.weymouth.watchmaker;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.watchmaker.framework.CandidateFactory;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionObserver;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.FitnessEvaluator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.PopulationData;
import org.uncommons.watchmaker.framework.SelectionStrategy;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.Stagnation;

public class Main {

	public static void main(String[] args) {
		(new Main()).exec();
	}

	private void exec() {
		CandidateFactory<Function> candidateFactory = new FunctionFactory();
		FitnessEvaluator<? super Function> fitnessEvaluator = new FunctionFitnessEvaluator();
		SelectionStrategy<? super Function> selectionStrategy = new RouletteWheelSelection();
		Random rng = new MersenneTwisterRNG();

		List<EvolutionaryOperator<Function>> operators = new LinkedList<EvolutionaryOperator<Function>>();
		operators.add(new FunctionCrossover());
		operators.add(new FunctionMutation());

		EvolutionaryOperator<Function> pipeline = new EvolutionPipeline<Function>(operators);
		
		EvolutionEngine<Function> engine =
			new GenerationalEvolutionEngine<Function>(candidateFactory,
				pipeline,
                fitnessEvaluator,
                selectionStrategy,
                rng);
	
		engine.addEvolutionObserver(new EvolutionObserver<Function>()
		{
		    public void populationUpdate(PopulationData<? extends Function> data)
		    {
		        System.out.printf("Generation %d: %s\n",
		                          data.getGenerationNumber(),
		                          data.getBestCandidate());
		    }
		});
		
		int populationSize = 50;
		int eliteCount = 5;
		int generationLimit = 100;
		boolean naturalFitness = false;
		engine.evolve(populationSize,eliteCount,new Stagnation(generationLimit, naturalFitness) );
	        
	}
}
