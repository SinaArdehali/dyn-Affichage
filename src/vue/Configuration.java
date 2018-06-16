package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Configuration extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField configuration;
	Font f;

	public Configuration() {
		setLayout(null);

		this.setSize(800, 600);
		this.setLocation(0, 0);

		configuration = new JTextField();
		f = new Font("Courrier", Font.BOLD, 20);
		configuration = new JTextField();
		configuration.setSize(500, 40);
		configuration.setLocation(5, 5);
		configuration.setText("Bienvenue sur votre page d'accueil");
		configuration.setFont(f);
		configuration.setBackground(null);
		configuration.setBorder(null);
		configuration.setEditable(false);
		add(configuration);

		JLabel lblBDD = new JLabel("Nom de la base de donnée : ");
		lblBDD.setSize(250, 30);
		lblBDD.setLocation(200, 200);
		lblBDD.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblBDD);

		JTextField nomBase = new JTextField();
		nomBase.setSize(100, 30);
		nomBase.setLocation(500, 200);
		nomBase.setText("dynaffichage");
		nomBase.setEditable(false);
		nomBase.setHorizontalAlignment(SwingConstants.CENTER);
		add(nomBase);

		JLabel lblPort = new JLabel("Numero de port : ");
		lblPort.setSize(250, 30);
		lblPort.setLocation(200, 300);
		lblPort.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPort);

		JTextField numPort = new JTextField();
		numPort.setSize(100, 30);
		numPort.setLocation(500, 300);
		numPort.setText("80");
		numPort.setEditable(false);
		numPort.setHorizontalAlignment(SwingConstants.CENTER);
		add(numPort);

		JLabel lblAccesServeur = new JLabel("Chemin d'acces fichier du Serveur : ");
		lblAccesServeur.setSize(250, 30);
		lblAccesServeur.setLocation(200, 400);
		lblAccesServeur.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblAccesServeur);

		JTextField nomDossier = new JTextField();
		nomDossier.setSize(150, 30);
		nomDossier.setLocation(500, 400);
		nomDossier.setEditable(false);
		nomDossier.setHorizontalAlignment(SwingConstants.CENTER);
		nomDossier.setText("www/dynaffichage");
		add(nomDossier);

		JButton btnAnnuler = new JButton("Retour");
		btnAnnuler.setBounds(300, 500, 200, 40);
		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				changementVue();
			}
		});
		add(btnAnnuler);

	}

	private void changementVue() {
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
