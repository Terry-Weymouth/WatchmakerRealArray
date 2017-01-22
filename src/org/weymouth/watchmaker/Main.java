package org.weymouth.watchmaker;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.CandidateFactory;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.SelectionStrategy;
import org.uncommons.watchmaker.framework.TerminationCondition;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.TargetFitness;

public class Main {
	
	public static final int NUMBER_OF_PARAMETERS = 5;
	
	public static void main(String[] args) {
		(new Main()).exec();
	}

	private void exec() {
		
		FunctionController controller = new FunctionController();
		
		controller.setupGui();
		
		CandidateFactory<Function> candidateFactory = new FunctionFactory();
		FunctionFitnessEvaluator fitnessEvaluator = new FunctionFitnessEvaluator();
		SelectionStrategy<? super Function> selectionStrategy = new RouletteWheelSelection();
		Random rng = new MersenneTwisterRNG();

		List<EvolutionaryOperator<Function>> operators = new LinkedList<EvolutionaryOperator<Function>>();
		operators.add(new FunctionCrossover(1));
		operators.add(new FunctionMutation(new Probability(0.3)));
		operators.add(new FunctionScramble(new Probability(0.3)));
		operators.add(new FunctionReplace(new Probability(0.1)));

		EvolutionaryOperator<Function> pipeline = new EvolutionPipeline<Function>(operators);
		
		EvolutionEngine<Function> engine =
			new GenerationalEvolutionEngine<Function>(candidateFactory,
				pipeline,
                fitnessEvaluator,
                selectionStrategy,
                rng);
	
		engine.addEvolutionObserver(new FunctionEvolutionObserver(fitnessEvaluator));
		engine.addEvolutionObserver(controller.getEvolutionObserver());
		
		boolean naturalFitness = false;		
		
//		int generationLimit = 10000;
//		TerminationCondition t1 = new Stagnation(generationLimit, naturalFitness);
	
		double targetFitness = 0.01;
		TerminationCondition t2 = new TargetFitness(targetFitness,naturalFitness);
		
		int populationSize = 1000;
		int eliteCount = 5;
		
		engine.evolve(populationSize,eliteCount,t2);
	        
	}

}
