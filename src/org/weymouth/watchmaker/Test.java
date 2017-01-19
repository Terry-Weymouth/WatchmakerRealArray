package org.weymouth.watchmaker;

public class Test {

	public static void main(String[] args) {
		TargetFunction testFn = new TargetFunction();
		Function ideal = Function.makeIdeal();
		double y1 = testFn.ideal_value(100.0);
		double y2 = testFn.value(100, ideal.getParameters());
		System.out.println(y1);
		System.out.println(y2);
	}
}
