package Builder;

import Models.Food;
import Models.HotDog;

public class HotdogBuilder implements FoodBuilder {
	private Food food;

	public HotdogBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FoodBuilder reset() {
		food = new HotDog(null, 0);
		return this;
	}

	@Override
	public FoodBuilder buildName(String name) {
		food.setFoodName(name);
		return this;
	}

	@Override
	public FoodBuilder buildPrice(int price) {
		food.setFoodPrice(price);
		return this;
	}

	@Override
	public Food getFood() {
		return food;
	}

}
