package org.weymouth.watchmaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Function {

	private static final int NUMBER_OF_PARAMETERS = 5;
	private List<Double> parameters = new ArrayList<Double>();
	
	public Function(Random rng) {
		for (int i = 0; i < NUMBER_OF_PARAMETERS; i++) {
			parameters.add(new Double(rng.nextDouble()));
		}
	}
	
	public String toString() {
		String ret = null;
		for (int i = 0; i < NUMBER_OF_PARAMETERS; i++) {
			double p = parameters.get(i).doubleValue();
			if (ret == null) {
				ret = "Function Parameters: " + p;
			} else {
				ret += ", " + p;
			}
		}
		return ret;
	}

	public double fit() {
		// TODO Auto-generated method stub
		return 0;
	}

}
