package Models;

public class Burger extends Food {

	public Burger(String foodName, int foodPrice) {
		super(foodName, foodPrice);
		this.category = "Burger";
	}

	@Override
	public void printFood() {
		System.out.printf("| %-20s | %-10d | %-13s |\n", this.getFoodName(), this.getFoodPrice(),
				this.getCategory());
	}

}
