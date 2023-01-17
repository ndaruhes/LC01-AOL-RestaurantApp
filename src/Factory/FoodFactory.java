package Factory;

import Models.*;

public class FoodFactory {
	private static FoodFactory fc = null;

	public static FoodFactory getFoodFactory() {
		if (fc == null) {
			fc = new FoodFactory();
		}
		return fc;
	}

	public Food MakeFood(int Food) {
		switch (Food) {
		case 1:
			return new Burger("Burger Bangor", 75000);
		case 2:
			return new Pizza("Pizza Hat", 125000);
		case 3:
			return new HotDog("Hot Dog Pak Madew", 99900);
		}
		return null;
	}
}
