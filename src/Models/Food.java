package Models;

public abstract class Food {
	protected String foodName, category;
	protected int foodPrice;
	
	public Food(String foodName, int foodPrice) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public abstract void printFood();
}
