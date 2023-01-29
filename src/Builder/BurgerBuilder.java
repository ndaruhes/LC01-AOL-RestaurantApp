package Builder;

import Models.*;

public class BurgerBuilder implements FoodBuilder {
	private Food food;

	public BurgerBuilder() {
		
	}

	@Override
	public FoodBuilder reset() {
		food = new Burger(null, 0);
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
