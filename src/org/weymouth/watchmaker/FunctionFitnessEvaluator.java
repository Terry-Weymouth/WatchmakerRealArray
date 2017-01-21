package org.weymouth.watchmaker;

import java.util.List;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

public class FunctionFitnessEvaluator implements FitnessEvaluator<Function> {

	private static final double INIT_X = -75.0;
	private static final double DELTA_X = 0.5;
	private static final int NUMBER_OF_POINTS = 300;
	
	private TargetFunction target = new TargetFunction();

	@Override
	public double getFitness(Function fn, List<? extends Function> list) {
		List<Double> parameters = fn.getParameters();
		List<Double> idealp = target.getIdealParameter();
		double error = 0.0;
		for (int i = 0; i < Main.NUMBER_OF_PARAMETERS; i++ ){
			double ideal = idealp.get(i).doubleValue();
			double actual = parameters.get(i).doubleValue();
			double delta = ideal - actual;
			error += delta * delta;
		}
		return error/(double)Main.NUMBER_OF_PARAMETERS;
	}

	@Override
	public boolean isNatural() {
		return false;
	}

}
