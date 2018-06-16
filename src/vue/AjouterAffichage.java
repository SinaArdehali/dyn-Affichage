package vue;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;

import model.DonneeAffichage;

public class AjouterAffichage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField chemin, nomFichier, nomAffichage, description;
	FileView apercu;
	File image;
	String direction, nom;
	Boolean retourBDD = false;

	public AjouterAffichage() {
		setLayout(null);

		this.setSize(800, 600);
		this.setLocation(0, 0);

		JLabel titre = new JLabel("Ajouter un affichage");
		titre.setSize(800, 50);
		titre.setLocation(0, 0);
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		add(titre);

		nomAffichage = new JTextField();
		nomAffichage.setSize(350, 30);
		nomAffichage.setLocation(50, 80);
		nomAffichage.setText("Inscrire ici le nom de votre affichage");
		nomAffichage.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (nomAffichage.getText().trim().equals("Inscrire ici le nom de votre affichage")) {
					nomAffichage.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (nomAffichage.getText().trim().equals("")) {
					nomAffichage.setText("Inscrire ici le nom de votre affichage");
				}
			}
		});
		add(nomAffichage);

		chemin = new JTextField();
		chemin.setSize(350, 30);
		chemin.setLocation(50, 130);
		chemin.setText("Chemin d'acces à votre image");
		chemin.setEditable(false);
		add(chemin);

		nomFichier = new JTextField();
		nomFichier.setSize(170, 30);
		nomFichier.setLocation(430, 130);
		nomFichier.setText("Nom du fichier selectionné");
		nomFichier.setEditable(false);
		add(nomFichier);

		JButton btnParcourir = new JButton("Parcourir");
		btnParcourir.setSize(100, 30);
		btnParcourir.setLocation(620, 130);
		btnParcourir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file;
				file = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png", "gif", "JPG & GIF Images");
				file.showOpenDialog(null);
				image = file.getSelectedFile();
				file.setFileFilter(filter);
				direction = image.getAbsolutePath();
				nom = file.getSelectedFile().getName();
				apercu = file.getFileView();
				nomFichier.setText(nom);
				chemin.setText(direction);
			}
		});
		add(btnParcourir);

		description = new JTextField();
		description.setSize(700, 40);
		description.setLocation(50, 450);
		description.setText("Inscrire ici un commentaire à afficher");
		description.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (description.getText().trim().equals("Inscrire ici un commentaire à afficher")) {
					description.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (description.getText().trim().equals("")) {
					description.setText("Inscrire ici un commentaire à afficher (facultatif)");
				}
			}
		});
		add(description);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(50, 500, 200, 40);
		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				changementVue();
			}
		});
		add(btnAnnuler);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(550, 500, 200, 40);
		btnValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (nomAffichage.getText().trim().equals("Inscrire ici le nom de votre affichage")
						| nomFichier.getText().trim().equals("Nom du fichier selectionné")) {
					JOptionPane.showMessageDialog(null, "Nom d'affichage ou fichier image oublié !");
				} else {

					DonneeAffichage donnee = new DonneeAffichage();
					retourBDD = donnee.AjouterAffichage(nomAffichage.getText(), chemin.getText(), nomFichier.getText(),
							description.getText());
					if (retourBDD == true) {
						JOptionPane.showMessageDialog(null,
								"enregistrement effectué avec succes dans la base de donnée");
						changementVue();
						retourBDD = false;
					} else {
						JOptionPane.showMessageDialog(null,
								"erreur lors de l'enregistrement, veuillez verifier vos informations");
					}
				}
			}
		});
		add(btnValider);

		JLabel img = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/moniteur.png")).getImage();
		img.setIcon(new ImageIcon(image));
		img.setSize(800, 450);
		img.setLocation(0, 180);
		img.setHorizontalAlignment(SwingConstants.CENTER);
		add(img);

	}

	private void changementVue() {
		PageAccueil pa = new PageAccueil();
		this.removeAll();
		this.repaint();
		this.revalidate();
		this.add(pa);
		this.repaint();
		this.revalidate();
	}

}
