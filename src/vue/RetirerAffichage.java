package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.DonneeAffichage;

public class RetirerAffichage extends JPanel {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	boolean erreur = false;
	ArrayList<String> tab = new ArrayList<>();
	Graphics g;
	boolean verif = false;

	public RetirerAffichage() {
		setLayout(null);

		this.setSize(800, 600);
		this.setLocation(0, 0);
		JScrollPane fenetreResultat = new JScrollPane();
		fenetreResultat.setPreferredSize(new Dimension(200, 300));
		tab = chargementAffichage();
		for (int i = 0; i < tab.size(); i++) {
			JLabel listeAffichage = new JLabel("Affichage n° " + i + " :");
			listeAffichage.setSize(200, 20);
			listeAffichage.setLocation(50, (i + 2) * 50 + 5);
			listeAffichage.setText(tab.get(i));
			add(listeAffichage);

			JButton supprimer = new JButton();
			supprimer.setLocation(450, (i + 2) * 50 + 5);
			supprimer.setSize(100, 30);
			supprimer.setBackground(Color.RED);
			supprimer.setText("Supprimer");
			supprimer.setForeground(Color.WHITE);
			add(supprimer);

			supprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (verif = true) {
						suppressionVue(listeAffichage.getText());
						JOptionPane.showMessageDialog(null, "suppression effectué avec succes");
						changementVue();
						verif = false;
					} else
						JOptionPane.showMessageDialog(null,
								"erreur lors de l'enregistrement, \n veuillez verifier vos informations");

				}
			});

		}

		JButton btnAnnuler = new JButton("Retour Menu");
		btnAnnuler.setBounds(300, 20, 200, 40);
		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				changementVue();
			}
		});
		add(btnAnnuler);

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

	private ArrayList<String> chargementAffichage() {
		ArrayList<String> tab = new ArrayList<>();
		HashMap<String, ArrayList<String>> liste = new HashMap<>();
		DonneeAffichage valeur = new DonneeAffichage();
		liste = valeur.listeAffichage();
		tab = liste.get("nomAffichage");
		return tab;
	}

	private boolean suppressionVue(String nomAffichage) {
		boolean verif = false;
		DonneeAffichage da = new DonneeAffichage();
		verif = da.suppressionVue(nomAffichage);

		return verif;
	}
}
