package Mediator;

import Models.Food;
import Models.Customer.People;

public interface MediatorOrder {
	public void SendOrder(People customerID, Food foodID);

	public void reciveAllOrder();

	public void ReciveOrder(String CustomerID);
}
