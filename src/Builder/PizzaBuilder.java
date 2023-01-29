package Builder;

import Models.Food;
import Models.Pizza;

public class PizzaBuilder implements FoodBuilder {
	private Food food;

	public PizzaBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FoodBuilder reset() {
		food = new Pizza(null, 0);
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