package vue;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;

public class DiversFonction extends JPanel {

	/**
	 * Create the panel.
	 */
	public DiversFonction() {
		setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(72, 138, 121, 23);
		add(tglbtnNewToggleButton);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(296, 11, 17, 256);
		add(scrollBar);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 243, 146, 14);
		add(progressBar);

	}
}
