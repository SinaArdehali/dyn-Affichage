package vue;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.AccesBDD;

public class GestionIdentification extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField identifiant;
	private JTextField ancienMotDePasse;
	private JTextField nouveauMotDePasse;
	private JTextField confirmationMotDePasse;
	String oldLogin = Identification.identifiant;
	Boolean verif = false;
	AccesBDD da = new AccesBDD();

	public GestionIdentification() {
		setLayout(null);

		this.setSize(800, 600);
		this.setLocation(0, 0);

		JLabel img = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/logomodif.png")).getImage();
		img.setIcon(new ImageIcon(image));
		img.setSize(300, 250);
		img.setLocation(10, 180);
		add(img);

		JLabel lblPage = new JLabel("Votre identifiant actuel");
		lblPage.setSize(800, 50);
		lblPage.setLocation(0, 0);
		lblPage.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPage);

		identifiant = new JTextField();
		identifiant.setLocation(300, 75);
		identifiant.setSize(250, 30);
		identifiant.setText("saisir ici votre nouvel identifiant");
		identifiant.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (identifiant.getText().trim().equals("")) {
					identifiant.setBackground(Color.WHITE);
					identifiant.setText("saisir ici votre nouvel identifiant");
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (identifiant.getText().trim().equals("saisir ici votre nouvel identifiant")) {
					identifiant.setBackground(Color.ORANGE);
					identifiant.setText("");
				}

			}
		});
		add(identifiant);

		JButton btnConfirmer = new JButton("Valider votre nouvel identifiant");
		btnConfirmer.setBounds(300, 110, 250, 40);
		btnConfirmer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				enregistrementNouvelIdentifiant(identifiant.getText());
				if (verif) {
					JOptionPane.showMessageDialog(null, "changement d'identifiant fait avec succes");
					new Fenetre();
					verif = false;
				} else {
					JOptionPane.showMessageDialog(null,
							"erreur lors de l'enregistrement de votre identifiant aucun changement n'a ete effectué");
				}
			}
		});
		add(btnConfirmer);

		ancienMotDePasse = new JTextField();
		ancienMotDePasse.setLocation(300, 260);
		ancienMotDePasse.setSize(250, 30);
		ancienMotDePasse.setText("saisir ici votre mot de passe actuel");
		ancienMotDePasse.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (ancienMotDePasse.getText().trim().equals("")) {
					ancienMotDePasse.setBackground(Color.WHITE);
					ancienMotDePasse.setText("saisir ici votre mot de passe actuel");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (ancienMotDePasse.getText().trim().equals("saisir ici votre mot de passe actuel")) {
					ancienMotDePasse.setBackground(Color.ORANGE);
					ancienMotDePasse.setText("");

				}
			}
		});
		add(ancienMotDePasse);

		nouveauMotDePasse = new JTextField();
		nouveauMotDePasse.setLocation(300, 310);
		nouveauMotDePasse.setSize(250, 30);
		nouveauMotDePasse.setText("saisir ici votre nouveau mot de passe");
		nouveauMotDePasse.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (nouveauMotDePasse.getText().trim().equals("")) {
					nouveauMotDePasse.setBackground(Color.WHITE);
					nouveauMotDePasse.setText("saisir ici votre nouveau mot de passe");
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (nouveauMotDePasse.getText().trim().equals("saisir ici votre nouveau mot de passe")) {
					nouveauMotDePasse.setBackground(Color.ORANGE);
					nouveauMotDePasse.setText("");

				}

			}
		});
		add(nouveauMotDePasse);

		confirmationMotDePasse = new JTextField();
		confirmationMotDePasse.setLocation(300, 350);
		confirmationMotDePasse.setSize(250, 30);
		confirmationMotDePasse.setText("saisir à nouveau votre mot de passe");
		confirmationMotDePasse.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (confirmationMotDePasse.getText().trim().equals("")) {
					confirmationMotDePasse.setBackground(Color.WHITE);
					confirmationMotDePasse.setText("saisir à nouveau votre mot de passe");
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (confirmationMotDePasse.getText().trim().equals("saisir à nouveau votre mot de passe")) {
					confirmationMotDePasse.setBackground(Color.ORANGE);
					confirmationMotDePasse.setText("");

				}

			}
		});
		add(confirmationMotDePasse);

		JButton btnConfirmerMDP = new JButton("Valider votre nouveau mot de passe");
		btnConfirmerMDP.setBounds(300, 400, 250, 40);
		btnConfirmerMDP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				verif = enregistrementNouveauMotDePasse();
				if (verif) {
					JOptionPane.showMessageDialog(null, "Mot de passe rectifier avec succes");
					retourPageAccueil();
					verif = false;
				} else {
					JOptionPane.showMessageDialog(null, "Erreur de saisie, veuillez verifier votre saisie");
				}

			}
		});
		add(btnConfirmerMDP);

		JButton btnAnnuler = new JButton("retour menu");
		btnAnnuler.setBounds(300, 500, 260, 40);
		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				retourPageAccueil();
			}
		});
		add(btnAnnuler);

	}

	private void retourPageAccueil() {
		PageAccueil pa = new PageAccueil();
		this.removeAll();
		this.repaint();
		this.revalidate();
		this.add(pa);
		this.repaint();
		this.revalidate();
	}

	private boolean enregistrementNouvelIdentifiant(String newLogin) {

		verif = da.modifLogin(newLogin, oldLogin);
		new AccesBDD();
		return verif;
	}

	private boolean enregistrementNouveauMotDePasse() {

		String login = Identification.identifiant;
		AccesBDD adb = new AccesBDD();
		boolean verifIdentification = adb.identification(login, ancienMotDePasse.getText());
		boolean verifNewPass = false;
		if (!verifIdentification) {
			JOptionPane.showMessageDialog(null, "mot de passe actuel incorrect");
		}
		if (nouveauMotDePasse.getText().equals(confirmationMotDePasse.getText())) {
			verifNewPass = true;
		} else {
			JOptionPane.showMessageDialog(null, "la confirmation du mot de passe ne correspond pas, reessayer");
			nouveauMotDePasse.setText("");
			confirmationMotDePasse.setText("");
		}

		if (verifIdentification == true && verifNewPass == true) {
			verif = adb.modifPass(confirmationMotDePasse.getText(), login);
		}

		return verif;
	}
}
