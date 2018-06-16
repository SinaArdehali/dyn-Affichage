package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesBDD {

	protected static Connection getConnection() {
		Connection cnx = null;
		String url = "jdbc:mysql://localhost/dynaffichage";
		String login = "root";
		String password = "formation";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return cnx;
	}

	public boolean identification(String login, String motDePasse) {
		Connection cnx;
		cnx = getConnection();
		ResultSet rs = null;
		PreparedStatement statement;
		String password;
		boolean validation = false;
		try {
			statement = cnx.prepareStatement("select * from user where identifiant=? ");
			statement.setString(1, login);
			rs = statement.executeQuery();
			rs.next();
			password = rs.getString("motDePasse");
			if (password.equals(motDePasse)) {
				validation = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validation;
	}

	public boolean modifLogin(String newLogin, String oldLogin) {
		Connection cnx = getConnection();
		boolean verif = false;
		PreparedStatement statement;

		try {
			statement = cnx.prepareStatement("UPDATE user SET identifiant = ? WHERE identifiant = ?");
			statement.setString(1, newLogin);
			statement.setString(2, oldLogin);
			statement.executeUpdate();
			verif = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return verif;
	}

	public boolean modifPass(String newPass, String identifiant) {
		Connection cnx = getConnection();
		boolean verif = false;
		PreparedStatement statement;

		try {
			statement = cnx.prepareStatement("UPDATE user SET motDePasse =? WHERE identifiant = ?");
			statement.setString(1, newPass);
			statement.setString(2, identifiant);
			statement.executeUpdate();
			verif = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return verif;
	}

}
