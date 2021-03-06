package org.weymouth.watchmaker;

import java.util.List;
import java.util.Random;

import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

public class FunctionMutation implements EvolutionaryOperator<Function> {
	
	private final Probability p;

	public FunctionMutation(Probability probability) {
		p = probability;
	}

	@Override
	public List<Function> apply(List<Function> list, Random rng) {
		for (Function f: list) {
			if (p.nextEvent(rng)){
				f.mutate(rng);
			}			
		}
		return list;
	}

}
