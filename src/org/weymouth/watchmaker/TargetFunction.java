package org.weymouth.watchmaker;

import java.util.ArrayList;
import java.util.List;

public class TargetFunction {
	
	private static final double[] IDEAL_PARAMETERS = {5.0, 1.0, 0.0, 0.0, 0.0};

	private List<Double> idealParameters = new ArrayList<Double>();

	public TargetFunction() {
		for (int i = 0; i < IDEAL_PARAMETERS.length; i++){
			idealParameters.add(new Double(IDEAL_PARAMETERS[i]));
		}
	}
	
	public List<Double> getIdealParameter(){
		return idealParameters;
	}
	
	public double ideal_value(double x) {
		return function(x,idealParameters);
	}
	
	public double value(double x, List<Double> parameters){
		return function(x,parameters);
	}

	private double function(double x, List<Double> parameters) {
		double y = 0.0;
		double factor = 1.0;
		for (Double parameter: parameters) {
			y += factor * parameter.doubleValue();
			factor *= x;
		}
		return y;
	}
	
}
