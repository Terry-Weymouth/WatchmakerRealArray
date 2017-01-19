package org.weymouth.watchmaker;

import org.uncommons.watchmaker.framework.PopulationData;
import org.uncommons.watchmaker.swing.evolutionmonitor.EvolutionMonitor;

public class FunctionEvolutionObserver extends EvolutionMonitor<Function> {

	private final FunctionFitnessEvaluator fitnessEvaluator;
	
	public FunctionEvolutionObserver(FunctionFitnessEvaluator fe) {
		super();
		this.fitnessEvaluator = fe;
	}

	public void populationUpdate(PopulationData<? extends Function> data)
    {
		super.populationUpdate(data);
    	Function fn = data.getBestCandidate();
    	double error = fitnessEvaluator.getFitness(fn, null);
        System.out.printf("Generation %d: (%f) %s\n",
                          data.getGenerationNumber(),
                          error,
                          fn);
    }

}
