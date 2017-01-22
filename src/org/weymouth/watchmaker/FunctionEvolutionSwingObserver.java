package org.weymouth.watchmaker;

import org.uncommons.watchmaker.swing.evolutionmonitor.EvolutionMonitor;

public class FunctionEvolutionSwingObserver
		extends EvolutionMonitor<Function>{

	public FunctionEvolutionSwingObserver(FunctionController controller){
		super(new FunctionRenderer(controller),false);
	}
	
}
