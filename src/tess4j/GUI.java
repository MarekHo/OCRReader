package tess4j;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUI {

	public static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("OCR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JComponent newContentPane = new ProgressBar();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
}
