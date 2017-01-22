package org.weymouth.watchmaker;

import javax.swing.JPanel;

import org.uncommons.watchmaker.framework.EvolutionObserver;
import org.uncommons.watchmaker.swing.evolutionmonitor.EvolutionMonitor;

public class FunctionController {
	
	private EvolutionMonitor<Function> monitor;

	public JPanel getJPanel() {
		JPanel ret = new JPanel();
		monitor = new EvolutionMonitor<Function>();
		ret.add(monitor.getGUIComponent());
		return ret;
	}

	public EvolutionObserver<? super Function> getEvolutionObserver() {
		return monitor;
	}

}
