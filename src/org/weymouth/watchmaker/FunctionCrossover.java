package org.weymouth.watchmaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

public class FunctionCrossover extends AbstractCrossover<Function> {

	protected FunctionCrossover(int crossoverPoints) {
		super(crossoverPoints);
	}

	@Override
	protected List<Function> mate(Function parent1, Function parent2, int numberOfCrossoverPoints, Random rng) {
		List<Function> ret = new ArrayList<Function>();
		ret.add(parent1.cross(parent2,rng));
		ret.add(parent2.cross(parent1,rng));
		return ret;
	}

}
