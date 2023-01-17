package Models;

public class Pizza extends Food{

	public Pizza(String foodName, int foodPrice) {
		super(foodName, foodPrice);
		this.category = "Pizza";
	}

	@Override
	public void printFood() {
		System.out.printf("Name : %s\nPrice : %s\nCategory : %s\n\n", this.getFoodName(), this.getFoodPrice(),
				this.getCategory());
	}

}
