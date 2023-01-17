package Models;

public class HotDog extends Food {

	public HotDog(String foodName, int foodPrice) {
		super(foodName, foodPrice);
		this.category = "Hot Dog";
	}

	@Override
	public void printFood() {
		System.out.printf("Name : %s\nPrice : %s\nCategory : %s\n\n", this.getFoodName(), this.getFoodPrice(),
				this.getCategory());
	}

}