package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import model.DonneeAffichage;

public class AffichageEnCours extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean validation = false;
	ArrayList<String> tab = new ArrayList<>();
	HashMap<String, Integer> active = new HashMap<>();

	public AffichageEnCours() {
		setLayout(null);

		this.setSize(800, 600);
		// Pour un affichage trop important de la liste des affiches: ajouter
		// cette ligne à la place de la precedente
		// this.setPreferredSize(new Dimension(800, 600));
		this.setLocation(0, 0);

		tab = chargementAffichage();
		for (int i = 0; i < tab.size(); i++) {
			JLabel listeAffichage = new JLabel("Affichage n° " + i + " :");
			listeAffichage.setSize(200, 20);
			listeAffichage.setLocation(50, (i + 2) * 50);
			listeAffichage.setText(tab.get(i));
			add(listeAffichage);

			JToggleButton toggleButton = new JToggleButton("Choisir l'état");
			ItemListener itemListener = new ItemListener() {
				public void itemStateChanged(ItemEvent itemEvent) {
					int state = itemEvent.getStateChange();
					if (state == ItemEvent.SELECTED) {
						toggleButton.setText("Activé");
						active.put(listeAffichage.getText(), 1);

					} else {
						toggleButton.setText("Desactivé");
						toggleButton.setBackground(Color.ORANGE);
						active.put(listeAffichage.getText(), 0);

					}
				}
			};

			toggleButton.setLocation(450, (i + 2) * 50 + 5);
			toggleButton.setSize(180, 20);
			toggleButton.addItemListener(itemListener);
			add(toggleButton);

		}

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setSize(200, 40);
		btnAnnuler.setLocation(50, 10);
		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				changementVue();
			}
		});

		add(btnAnnuler);

		JButton btnValider = new JButton("Valider");
		btnValider.setSize(200, 40);
		btnValider.setLocation(450, 10);
		btnValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (activationVue() == true) {
					JOptionPane.showMessageDialog(null, "Modification effectuée avec succés");
					changementVue();
					validation = false;
				} else {
					JOptionPane.showMessageDialog(null,
							"erreur lors de l'enregistrement, veuillez verifier vos informations");
				}

			}
		});
		add(btnValider);

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

	private boolean activationVue() {
		boolean validation = false;
		DonneeAffichage da = new DonneeAffichage();
		validation = da.etatAffichage(active);
		return validation;
	}

}
