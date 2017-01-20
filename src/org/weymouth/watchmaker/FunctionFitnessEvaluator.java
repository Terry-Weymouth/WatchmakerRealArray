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
		double error = 0.0;
		double x = INIT_X;
		for (int i = 0; i < NUMBER_OF_POINTS; i++ ){
			double ideal = target.ideal_value(x);
			double actual = target.value(x, parameters);
			x += DELTA_X;
			double delta = ideal - actual;
			error += delta * delta;
		}
		return error/(double)NUMBER_OF_POINTS;
	}

	@Override
	public boolean isNatural() {
		return false;
	}

}
