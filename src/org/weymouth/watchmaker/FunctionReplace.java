package org.weymouth.watchmaker;

import java.util.List;
import java.util.Random;

import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

public class FunctionReplace implements EvolutionaryOperator<Function> {

	private final Probability p;

	public FunctionReplace(Probability probability) {
		p = probability;
	}

	@Override
	public List<Function> apply(List<Function> list, Random rng) {
		for (int i = 0; i < list.size(); i++) {
			if (p.nextEvent(rng)){
				Function f = new Function(rng);
				list.add(i,f);
				list.remove(i+1);
			}						
		}
		return list;
	}

}
