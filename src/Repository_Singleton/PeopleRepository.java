package Repository_Singleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Customer.*;

public class PeopleRepository {
	private static ArrayList<People> peopleList = null;

	public static ArrayList<People> getPeopleList() {
		if (peopleList == null) {
			peopleList = new ArrayList<People>();
		}

		return peopleList;
	}

	public static void getAllPeople() {
		Database db = Database.getConnection();
		try {
			PreparedStatement statement = db.prepareStatement("SELECT * FROM customer");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String name = result.getString("name");
				String address = result.getString("address");
				String username = result.getString("username");
				String password = result.getString("password");
				int age = result.getInt("age");
				People people = new Customer(name, address, password, username, age, null);
				peopleList.add(people);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean addCustomer(People people) {
		boolean isSuccess = false;
		Database db = Database.getConnection();
		try {
			PreparedStatement statement = db.prepareStatement(
					"INSERT INTO users (name, address, username, password, age) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, people.getName());
			statement.setString(2, people.getAddress());
			statement.setString(3, people.getUsername());
			statement.setString(4, people.getPassword());
			statement.setInt(5, people.getAge());
			int result = statement.executeUpdate();
			if (result > 0) {
				isSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
