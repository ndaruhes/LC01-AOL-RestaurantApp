package Repository_Singleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.*;

public class FoodRepository {
	private static ArrayList<Food> foodList = null;

	public static ArrayList<Food> getFoodList() {

		if (foodList == null) {
			foodList = new ArrayList<Food>();
		}

		return foodList;
	}

	public static void getAllFood() {
		Database db = Database.getConnection();
		try {
			PreparedStatement statement = db.prepareStatement("SELECT * FROM food");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String name = result.getString("name");
				int price = result.getInt("price");
				// String category = result.getString("category");

				if (name.equals("Burger")) {
					Food food = new Burger(name, price);
					foodList.add(food);
				} else if (name.equals("Hot Dog")) {
					Food food = new HotDog(name, price);
					foodList.add(food);
				} else {
					Food food = new Pizza(name, price);
					foodList.add(food);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean addFood(Food food) {
		boolean isSuccess = false;
		Database db = Database.getConnection();

		try {
			PreparedStatement statement = db.prepareStatement(
					"INSERT INTO food (name, price, category) VALUES (?, ?, ?)");
			statement.setString(1, food.getFoodName());
			statement.setInt(2, food.getFoodPrice());
			statement.setString(3, food.getCategory());
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
