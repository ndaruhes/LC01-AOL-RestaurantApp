package Repository_Singleton;

import java.util.*;
import Models.*;

public class FoodRepository {
	private static ArrayList<Food> foodList = null;

	public static ArrayList<Food> getFoodList() {
		synchronized (foodList) {
			if (foodList == null) {
				foodList = new ArrayList<Food>();
			}			
		}
		return foodList;
	}

}
