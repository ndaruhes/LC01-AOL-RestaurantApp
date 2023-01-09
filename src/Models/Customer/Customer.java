package Models.Customer;

import java.util.*;
import Models.*;

public class Customer extends People {
	private String memberType;
	private ArrayList<Food> listFood = null;

	public Customer(String name, String address, String password, String username, int age) {
		super(name, address, password, username, age);
		this.listFood = new ArrayList<Food>();
		this.setRole("Member");
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public ArrayList<Food> getListFood() {
		return listFood;
	}

	public void setListFood(ArrayList<Food> listFood) {
		this.listFood = listFood;
	}

}
