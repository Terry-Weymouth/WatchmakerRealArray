package org.weymouth.watchmaker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.CandidateFactory;

public class FunctionFactory implements CandidateFactory<Function> {
	
	@Override
	public List<Function> generateInitialPopulation(int populationSize, Random rng) {
		return makeInitialPopulation(populationSize,rng);
	}

	@Override
	public List<Function> generateInitialPopulation(int populationSize, Collection<Function> seedCandidates, Random rng) {
		return makeInitialPopulation(populationSize,rng);
	}

	@Override
	public Function generateRandomCandidate(Random rng) {
		return new Function(rng);
	}

	private List<Function> makeInitialPopulation(int populationSize, Random rng) {
		List<Function> ret = new ArrayList<Function>();
		for (int i = 0; i < populationSize; i++) {
			ret.add(new Function(rng));
		}
		return ret;
	}
}
