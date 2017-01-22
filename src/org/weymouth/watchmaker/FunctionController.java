package org.weymouth.watchmaker;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uncommons.watchmaker.framework.EvolutionObserver;
import org.uncommons.watchmaker.swing.evolutionmonitor.EvolutionMonitor;

public class FunctionController {
	
	private EvolutionMonitor<Function> monitor;
	private TargetFunction targetFunction = new TargetFunction();

	public JPanel getJPanel() {
		JPanel ret = new JPanel();
		monitor = new FunctionEvolutionSwingObserver(this);
		ret.add(monitor.getGUIComponent());
		return ret;
	}

	public EvolutionObserver<? super Function> getEvolutionObserver() {
		return monitor;
	}

	private static void fireItOff(final FunctionController c) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//Create and set up the window.
                JFrame frame = new JFrame("Function GA Learner");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(c.getJPanel());

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
	}

	public TargetFunction getTargetFunction() {
		return targetFunction;
	}

	public void setupGui() {
		FunctionController.fireItOff(this);
	}

}
