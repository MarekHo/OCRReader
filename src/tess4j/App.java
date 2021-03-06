package tess4j;

import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				BasicConfigurator.configure();
				GUI.createAndShowGUI();
			}
		});
	}

}