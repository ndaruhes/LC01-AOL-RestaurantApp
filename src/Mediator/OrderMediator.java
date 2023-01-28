package Mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import Models.Food;
import Models.Customer.People;

public class OrderMediator implements MediatorOrder {
	private Map<People, ArrayList<Food>> listOrder = null;

	public OrderMediator() {
		this.listOrder = new HashMap<>();
	}

	@Override
	public void SendOrder(People customerID, Food FoodID) {
		customerID.getListFood().add(FoodID);
		listOrder.put(customerID, customerID.getListFood());
	}

	@Override
	public void reciveAllOrder() {
		for (Entry<People, ArrayList<Food>> list : listOrder.entrySet()) {
			People cus = list.getKey();
			ArrayList<Food> OrderedFood = list.getValue();
			cus.ReviceOrder(cus.getName(), OrderedFood);
		}
	}

	@Override
	public void ReciveOrder(String CustomerID) {
		for (Entry<People, ArrayList<Food>> list : listOrder.entrySet()) {
			People cus = list.getKey();
			if (cus.getName().equals(CustomerID)) {
				ArrayList<Food> OrderedFood = list.getValue();
				cus.ReviceOrder(cus.getName(), OrderedFood);
				return;
			}
		}
		System.out.println("No Order From " + CustomerID + " !!");
	}
}
