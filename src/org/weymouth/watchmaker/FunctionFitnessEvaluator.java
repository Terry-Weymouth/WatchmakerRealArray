package org.weymouth.watchmaker;

import java.util.List;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

public class FunctionFitnessEvaluator implements FitnessEvaluator<Function> {

	@Override
	public double getFitness(Function fn, List<? extends Function> list) {
		return fn.fit();
	}

	@Override
	public boolean isNatural() {
		return false;
	}

}
