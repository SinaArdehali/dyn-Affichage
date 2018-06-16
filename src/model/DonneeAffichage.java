package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DonneeAffichage {

	java.sql.Connection cnx;

	public DonneeAffichage() {
		this.cnx = AccesBDD.getConnection();
	}

	public boolean AjouterAffichage(String nomAffichage, String cheminFichier, String nomFichier, String commentaire) {
		PreparedStatement statement;
		Boolean verif = false;

		try {
			statement = cnx.prepareStatement(
					"INSERT INTO content (nomAffichage,cheminFichier,nomFichier,commentaire,active) values (?,?,?,?,?)");
			statement.setString(1, nomAffichage);
			statement.setString(2, cheminFichier);
			statement.setString(3, nomFichier);
			statement.setString(4, commentaire);
			statement.setInt(5, 0);

			statement.executeUpdate();
			verif = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return verif;
	}

	public HashMap<String, ArrayList<String>> listeAffichage() {
		ArrayList<String> nom = new ArrayList<>();
		ArrayList<String> fichier = new ArrayList<>();
		ArrayList<String> commentaire = new ArrayList<>();
		ArrayList<String> active = new ArrayList<>();
		HashMap<String, ArrayList<String>> liste = new HashMap<>();

		PreparedStatement statement;
		ResultSet result;

		try {
			statement = cnx.prepareStatement("SELECT nomAffichage, nomFichier, commentaire, active FROM content");
			result = statement.executeQuery();

			while (result.next()) {
				String nomAffichage = result.getString("nomAffichage");
				nom.add(nomAffichage);

				String nomFichier = result.getString("nomFichier");
				fichier.add(nomFichier);

				String listecommentaire = result.getString("commentaire");
				commentaire.add(listecommentaire);

				String listeActive = result.getString("active");
				active.add(listeActive);

			}
			liste.put("nomAffichage", nom);
			liste.put("nomFichier", fichier);
			liste.put("commentaire", commentaire);
			liste.put("active", active);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return liste;
	}

	public boolean etatAffichage(HashMap<String, Integer> etat) {
		boolean verif = false;
		PreparedStatement statement;

		try {

			Set<String> nomAffichage = etat.keySet();
			Iterator<String> it = nomAffichage.iterator();
			while (it.hasNext()) {
				Object key = it.next();
				Object valeur = etat.get(key);

				statement = cnx.prepareStatement("UPDATE content SET active = ? WHERE nomAffichage = ? ");
				statement.setInt(1, (int) valeur);
				statement.setString(2, (String) key);
				statement.executeUpdate();
				verif = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return verif;
	}

	public boolean suppressionVue(String nomAffichage) {
		boolean verif = false;
		PreparedStatement statement;

		try {
			statement = cnx.prepareStatement("DELETE FROM content WHERE nomAffichage=?");
			statement.setString(1, nomAffichage);
			statement.executeUpdate();
			verif = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return verif;
	}

}
