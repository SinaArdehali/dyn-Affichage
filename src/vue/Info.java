package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Info extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Info() {
		setLayout(null);
		this.setSize(800, 600);
		this.setLocation(0, 0);

		JTextField version = new JTextField();
		version.setSize(350, 20);
		version.setLocation(225, 220);
		version.setHorizontalAlignment(SwingConstants.CENTER);
		version.setBackground(null);
		version.setBorder(null);
		version.setText("version 1.0");
		add(version);

		JTextField nomEditeur = new JTextField();
		nomEditeur.setSize(350, 20);
		nomEditeur.setLocation(225, 260);
		nomEditeur.setHorizontalAlignment(SwingConstants.CENTER);
		nomEditeur.setBackground(null);
		nomEditeur.setBorder(null);
		nomEditeur.setText("Developpeur : ARDEHALI Sina");
		add(nomEditeur);

		JTextField dateValidation = new JTextField();
		dateValidation.setSize(350, 20);
		dateValidation.setLocation(225, 290);
		dateValidation.setHorizontalAlignment(SwingConstants.CENTER);
		dateValidation.setBackground(null);
		dateValidation.setBorder(null);
		dateValidation.setText("Date de validation : Mai 2017");
		add(dateValidation);

		JTextField contact = new JTextField();
		contact.setSize(350, 20);
		contact.setLocation(225, 320);
		contact.setHorizontalAlignment(SwingConstants.CENTER);
		contact.setBackground(null);
		contact.setBorder(null);
		contact.setText("Courriel : sina.ardehali@gmail.com");
		add(contact);

		JButton btnRetour = new JButton("retour");
		btnRetour.setSize(100, 40);
		btnRetour.setLocation(350, 500);
		btnRetour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				retourIdentification();
			}
		});

		add(btnRetour);
	}

	private void retourIdentification() {
		Identification pa = new Identification();
		this.removeAll();
		this.repaint();
		this.revalidate();
		pa.setSize(800, 600);
		pa.setLocation(0, 0);
		this.add(pa);
		this.repaint();
		this.revalidate();
	}

}
