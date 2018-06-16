package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Splash extends JWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int delay = 5000;

	public Splash() {
		dispose(delay);
	}

	public Splash(int delay) {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new SplashPicture("/splash.png"));
		p.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
		getContentPane().add(p);
		setSize(749, 382);
		setLocationRelativeTo(null);
		setVisible(true);
		try {
			Thread.sleep(delay);
		} catch (Exception e) {
		}
	}

	public void dispose(int delay) {
		dispose();
		Splash s = new Splash(delay);
		s.dispose();
	}

	class SplashPicture extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Image img;

		public SplashPicture(String file) {
			img = new ImageIcon(getClass().getResource(file)).getImage();
			repaint();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (img == null)
				return;
			int w = img.getWidth(this);
			int h = img.getHeight(this);
			boolean zoom = (w > getWidth() || h > getHeight());
			if (zoom)
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			else
				g.drawImage(img, (getWidth() - w) / 2, (getHeight() - h) / 2, this);
		}

	}
}
