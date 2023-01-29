package Builder;

import Models.Food;

public interface FoodBuilder {
	public abstract FoodBuilder reset();

	public FoodBuilder buildName(String name);

	public FoodBuilder buildPrice(int price);

	public Food getFood();
}
