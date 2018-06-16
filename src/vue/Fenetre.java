package vue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fenetre() {

		this.setTitle("DynAffichage");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
		this.setIconImage(new ImageIcon("img/logoDynAffichage.png").getImage());

		Identification id = new Identification();
		this.getContentPane().add(id);
		id.setSize(800, 600);
		id.setLocation(0, 0);

	}

}
