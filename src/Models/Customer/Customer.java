package Models.Customer;

import java.util.*;

import Mediator.MediatorOrder;
import Models.*;

public class Customer extends People {
	private String memberType;

	public Customer(String name, String address, String password, String username, int age, MediatorOrder mediator) {
		super(name, address, password, username, age, mediator);
		this.listFood = new ArrayList<Food>();
		this.setRole("Member");
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public void addOrderMenu(Food foods) {
		for (Food food : listFood) {
			food.printFood();
		}
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
		System.out.printf("| %-3s | %-5s | %-8s | %-13s | %-8s |\n", "No", "Food", "Price", "Description", "Category");
		System.out.printf("%-16s=========%-16s\n", '=', '=');
		for (Food food : listFood) {
			food.printFood();
		}
		System.out.printf("%-16s=========%-16s\n", '=', '=');
	}

}
