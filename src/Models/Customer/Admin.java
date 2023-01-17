package Models.Customer;

import java.util.ArrayList;

import Mediator.MediatorOrder;
import Models.Food;

public class Admin extends People {

	public Admin(String name, String address, String password, String username, int age, MediatorOrder mediator) {
		super(name, address, password, username, age, mediator);
		this.setRole("Admin");
	}

	@Override
	public void PlaceOrder(Food FoodID) {
		orderMediator.SendOrder(this, FoodID);
	}

	@Override
	public void addFood(Food foodid) {
		this.listFood.add(foodid);
	}

	@Override
	public void ReviceOrder(String CustomerID, ArrayList<Food> listFood) {
		System.out.printf("%-16s=========%-16s", '=', '=');
		System.out.printf("| Customer Name : %-22s |\n", CustomerID);
		System.out.println("=======================");
		System.out.printf("| %-3s | %-5s | %-8s | %-13s | %-8s |", "No", "Food", "Price", "Description", "Category");
		System.out.printf("%-16s=========%-16s", '=', '=');
		for (Food food : listFood) {
			food.printFood();
		}
		System.out.printf("%-16s=========%-16s", '=', '=');
	}

}
