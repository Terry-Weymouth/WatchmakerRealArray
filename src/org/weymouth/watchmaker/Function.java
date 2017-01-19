package org.weymouth.watchmaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Function {

	private List<Double> parameters = new ArrayList<Double>();
	
	public static Function makeIdeal() {
		TargetFunction t = new TargetFunction();
		List<Double> p = new ArrayList<Double>();
		for (Double d: t.getIdealParameter()){
			p.add(d);
		}
		return new Function(p);
	}
	
	public Function(Random rng) {
		for (int i = 0; i < Main.NUMBER_OF_PARAMETERS; i++) {
			parameters.add(randomParameter(rng));
		}
	}
	
	private Double randomParameter(Random rng) {
		return new Double(rng.nextDouble() * 20.0 - 10.0);
	}
	
	private Function(List<Double> parameters) {
		this.parameters = parameters;
	}
	
	public List<Double> getParameters() {
		return parameters;
	}

	public String toString() {
		String ret = null;
		for (int i = 0; i < Main.NUMBER_OF_PARAMETERS; i++) {
			double p = parameters.get(i).doubleValue();
			if (ret == null) {
				ret = "Function Parameters: " + p;
			} else {
				ret += ", " + p;
			}
		}
		return ret;
	}

	public Function cross(Function other, Random rng) {
		List<Double> p = new ArrayList<Double>();
		int point = rng.nextInt(Main.NUMBER_OF_PARAMETERS - 1);
		for (int i = 0; i < point; i++) {
			p.add(parameters.get(i));
		}
		for (int i = point; i < Main.NUMBER_OF_PARAMETERS; i++) {
			p.add(other.parameters.get(i));
		}
		return new Function(p);
	}

	public void mutate(Random rng) {
		int point = rng.nextInt(Main.NUMBER_OF_PARAMETERS);
		double p = parameters.get(point);
		p += rng.nextDouble() * 2.0 - 1.0;
		if (p > 10.0) p = 10.0;
		if (p < -10.0) p = -10.0;
		parameters.add(point,p);
		parameters.remove(point+1);
	}

	public void scramble(Random rng) {
		for (int i = 0; i< 10; i++) {
			int point = rng.nextInt(Main.NUMBER_OF_PARAMETERS);
			double p = parameters.get(point);
			point = rng.nextInt(Main.NUMBER_OF_PARAMETERS);
			parameters.add(point,p);
			parameters.remove(point+1);			
		}
	}

}
