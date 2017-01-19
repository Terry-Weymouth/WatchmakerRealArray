package org.weymouth.watchmaker;

import java.util.List;
import java.util.Random;

import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

public class FunctionScramble implements EvolutionaryOperator<Function> {

	private final Probability p;
	
	public FunctionScramble(Probability probability) {
		p = probability;
	}

	@Override
	public List<Function> apply(List<Function> list, Random rng) {
		for (Function f: list) {
			if (p.nextEvent(rng)){
				f.scramble(rng);
			}			
		}
		return list;
	}

}
