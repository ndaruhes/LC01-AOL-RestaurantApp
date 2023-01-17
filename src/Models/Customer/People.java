package Models.Customer;

import java.util.ArrayList;

import Mediator.MediatorOrder;
import Models.Food;

public abstract class People {
	private String name, address, password, username, Role;
	private int age;
	protected ArrayList<Food> listFood = null;
	protected MediatorOrder orderMediator = null;

	public People(String name, String address, String password, String username, int age, MediatorOrder od) {
		super();
		this.name = name;
		this.address = address;
		this.password = password;
		this.username = username;
		this.age = age;
		this.orderMediator = od;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Food> getListFood() {
		return listFood;
	}

	public void setListFood(ArrayList<Food> listFood) {
		this.listFood = listFood;
	}

	public MediatorOrder getOrderMediator() {
		return orderMediator;
	}

	public void setOrderMediator(MediatorOrder orderMediator) {
		this.orderMediator = orderMediator;
	}

	public abstract void addFood(Food foodid);

	public abstract void ReviceOrder(String CustomerID, ArrayList<Food> list);

	public abstract void PlaceOrder(Food FoodID);

}
