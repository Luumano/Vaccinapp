package vaccinappJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.GregorianCalendar;

public class UserManager {
	static String DB_URL = "jdbc:mysql://localhost/vaccinapp";
	static String DB_USER = "root";
	static String DB_PASSWORD = "mysql";

	public boolean addUser(Users user) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			Connection conn = null;
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			String sqlCommand = "INSERT INTO users (nome, email, senha, cartaoSUS, cpf, genero) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sqlCommand);

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getCardSUS());
			stmt.setString(5, user.getCpf());
			stmt.setLong(6, user.getGender());

			int rowsAffected = stmt.executeUpdate();

			conn.close();
			stmt.close();

			return rowsAffected > 0;

		} catch (Exception e) {

		} finally {

		}
		return false;

	}

	public boolean updateUser(Users user) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();

			int id = user.getId();
			String newName = user.getName();
			String newEmail = user.getEmail();

			String sqlCommand = "UPDATE users SET nome = '" + newName + "', email = '" + newEmail + "' WHERE id = "
					+ id;
			stmt.execute(sqlCommand);

			int rowsUpdated = stmt.getUpdateCount();

			conn.close();
			return rowsUpdated > 0;
		} catch (Exception e) {

		} finally {

		}
		return false;
	}

	public static boolean isValidDate(GregorianCalendar date) {

		int year = date.get(GregorianCalendar.YEAR);
		int month = date.get(GregorianCalendar.MONTH);
		int day = date.get(GregorianCalendar.DAY_OF_MONTH);

		return (year >= 1 && month >= 0 && month <= 11 && day >= 1
				&& day <= date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
	}

	public static boolean isValidName(String name) {
		if (name.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
