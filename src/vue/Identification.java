package vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import model.AccesBDD;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Identification extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String identifiant;
	private JTextField id;
	private JTextField password;

	public Identification() {
		setLayout(null);

		JLabel img = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/identification.gif")).getImage();
		img.setIcon(new ImageIcon(image));
		img.setSize(400, 250);
		img.setLocation(550, 180);
		add(img);

		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (verifLogin() == true) {
					AccesPageAccueil();
					JOptionPane.showMessageDialog(null, "connecté en tant que " + id.getText());
					identifiant = id.getText();

				} else {
					JOptionPane.showMessageDialog(null, "identifiant ou mot de passe incorrect");
				}

			}

		});
		btnValider.setHorizontalTextPosition(SwingConstants.CENTER);
		btnValider.setLocation(350, 500);
		btnValider.setSize(100, 40);
		add(btnValider);

		JButton btnConfiguration = new JButton("Configuration");
		btnConfiguration.setSize(130, 20);
		btnConfiguration.setLocation(650, 20);
		btnConfiguration.setBackground(Color.ORANGE);
		btnConfiguration.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				affichageConfiguration();
			}
		});
		add(btnConfiguration);

		JButton btnInfo = new JButton("Info / Contact");
		btnInfo.setSize(130, 20);
		btnInfo.setLocation(650, 50);
		btnInfo.setBackground(Color.GREEN);
		btnInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				affichageInfo();
			}
		});
		add(btnInfo);

		JLabel lblBienvenue = new JLabel("Bienvenue dans votre interface");
		lblBienvenue.setSize(800, 50);
		lblBienvenue.setLocation(0, 0);
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBienvenue);

		JLabel lblPageIdentification = new JLabel("Page d'identification");
		lblPageIdentification.setSize(200, 50);
		lblPageIdentification.setLocation(307, 96);
		lblPageIdentification.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPageIdentification);

		id = new JTextField();
		id.setBounds(336, 218, 150, 30);
		add(id);
		id.setColumns(10);

		password = new JTextField();
		password.setBounds(336, 341, 150, 30);
		add(password);
		password.setColumns(10);

		JLabel lblVotreId = new JLabel("Votre identifiant");
		lblVotreId.setBounds(164, 220, 150, 30);
		add(lblVotreId);

		JLabel lblVotrePass = new JLabel("Votre mot de Passe");
		lblVotrePass.setBounds(164, 343, 150, 30);
		add(lblVotrePass);

	}

	private boolean verifLogin() {

		boolean validation = false;

		if (id.getText().equals("demo") & password.getText().equals("demo")) {
			validation = true;
		} else {

			AccesBDD verif = new AccesBDD();
			validation = verif.identification(id.getText(), password.getText());
		}

		return validation;
	}

	private void affichageConfiguration() {
		Configuration pc = new Configuration();
		appelDessinFenetre(pc);
	}

	private void affichageInfo() {
		Info info = new Info();
		appelDessinFenetre(info);
	}

	private void AccesPageAccueil() {
		PageAccueil pa = new PageAccueil();
		this.removeAll();
		this.repaint();
		this.revalidate();

		this.add(pa);
		this.repaint();
		this.revalidate();
	}

	private void appelDessinFenetre(JPanel fenetre) {
		this.removeAll();
		this.repaint();
		this.revalidate();
		this.add(fenetre);
		this.repaint();
		this.revalidate();

	}

}
