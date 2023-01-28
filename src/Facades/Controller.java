package Facades;

import java.util.*;

import Factory.FoodFactory;
import Models.*;
import Models.Customer.*;
import Repository_Singleton.FoodRepository;
import Repository_Singleton.PeopleRepository;
import Utils.*;
import Main.*;
import Mediator.MediatorOrder;

public class Controller {
	private Validasi valid = new Validasi();
	private Utils util = new Utils();

	public ArrayList<Food> getFoodRepo() {
		return FoodRepository.getFoodList();
	}

	public void registerMember(ArrayList<People> list, MediatorOrder OrderSystem) {
		String username, password, address, Name;
		int age;
		do {
			System.out.print("Input your name : ");
			Name = util.ScanLine();
		} while (!valid.checkName(Name));
		do {
			System.out.print("Input your ID/Username (Must be unique and min. 6 characters) [0 to exit]:  ");
			username = util.ScanLine();
			if (username.equals("0")) {
				return;
			}
			username = username.trim();
		} while (!valid.checkUsername(username, list));
		do {
			System.out.print("Input your address [0 to exit] : ");
			address = util.ScanLine();
			if (address.equals("0")) {
				return;
			}
		} while (!valid.checkAddress(username));
		do {
			System.out.print("Input your Age [0 to exit] : ");
			age = util.ScanInt();
			if (age == 0) {
				return;
			}
		} while (!valid.checkAge(age));

		do {
			System.out.print("Input your Password (At least 6 character and must contains 1 Symbol) [0 to exit] : ");
			password = util.ScanLine();
			if (password.equals("0")) {
				return;
			}
		} while (!valid.checkPassword(password));
		
		list.add(new Customer(Name, address, password, username, age, OrderSystem));
	}

	// Login Customer Or Admin
	public void loginMemberOrAdmin(ArrayList<People> list) {
		String username, password;
		int index = -1;
		do {
			System.out.print("Input your ID/Username [0 to exit]:  ");
			username = util.ScanLine();
			if (username.equals("0")) {
				return;
			}
			System.out.print("Input your Password :  ");
			password = util.ScanLine();
			index = valid.checkID(username, password, list);
		} while (index == -1);
		if (username.equals("Admin") && password.equals("Admin")) {
			new MainAdmin(true, (Admin) list.get(index), list);
		} else {
			new MainLogin(true, (Customer) list.get(index), list);
		}
	}

	public void viewMenu(ArrayList<Food> foodList) {
		util.clear();
		if (foodList.isEmpty()) {
			System.out.println("No Menu Aviable !");
			util.getchar();
			return;
		}
		System.out.printf("%-15s All Menu %-15s\n", ' ', ' ');
		System.out.printf("%-16s=========%-16s\n", '=', '=');
		System.out.printf("| %-3s | %-5s | %-8s | %-13s | %-8s |\n", "No", "Food", "Price", "Description", "Category");
		int x = 1;
		for (Food food : foodList) {
			System.out.print(x++);
			food.printFood();
		}
		System.out.printf("%-16s=========%-16s\n", '=', '=');
	}

	public void viewMyOrder(ArrayList<Food> foodList) {
		if (foodList.isEmpty()) {
			System.out.println("No Menu Has Ordered !");
			util.getchar();
			return;
		}
		System.out.printf("%-13s Ordered Menu %-13s\n", ' ', ' ');
		System.out.printf("%-16s=========%-16s\n", '=', '=');
		System.out.printf("| %-3s | %-5s | %-8s | %-13s | %-8s |\n", "No", "Food", "Price", "Description", "Category");
		int x = 1;
		for (Food food : foodList) {
			System.out.print(x++);
			food.printFood();
		}
		System.out.printf("%-16s=========%-16s\n", '=', '=');
		util.getchar();
	}

	public void OrderMenu(ArrayList<Food> list, Customer Customer) {
		viewMenu(list);
		if (list.isEmpty()) {
			return;
		}
		String input = "";
		int index = -1;
		do {
			System.out.println(list.size());
			System.out.print("Order menu (Use Menu ID or Name to Choose) : ");
			input = util.ScanLine();
			index = valid.checkFood(list, input);
		} while (index == -1);
		Customer.PlaceOrder(list.get(index - 1));
		util.getchar();
	}

	public void BuildAdmin(ArrayList<People> list, MediatorOrder OrderSystem) {
		if (valid.checkAdmin(list, OrderSystem)) {
			// System.out.println("MAZOK");
		}
	}

	public boolean printAllCustomer(ArrayList<People> list) {
		if (list.isEmpty()) {
			System.out.println("No Customer Has Order !");
			util.getchar();
			return false;
		}
		return true;
	}

	public boolean printCustomer(ArrayList<People> list) {
		if (list.isEmpty()) {
			System.out.println("No Customer !");
			util.getchar();
			return false;
		}
		int x = 1;
		for (People people : list) {
			System.out.printf("%d. %s\n", x++, people.getName());
		}
		return true;
	}

	public void print_customer_ordered(ArrayList<People> list, Admin admin) {
		if (printCustomer(list)) {
			int x = -1;
			do {
				System.out.println("Choose One Customer [Press 0 to Exit]: ");
				x = util.ScanInt();
				if (x == 0) {
					return;
				}
			} while (x < 1 || x > list.size());
			admin.getOrderMediator().ReciveOrder(list.get(x - 1).getName());
			util.getchar();
		}
	}

	public void ViewAllOrder(ArrayList<People> list, Admin admin) {
		if (printAllCustomer(list)) {
			admin.getOrderMediator().reciveAllOrder();
			util.getchar();
		}
	}

	void foodMenu() {
		System.out.println("1. Burger");
		System.out.println("2. Pizza");
		System.out.println("3. Hot Dog");
	}

	public void buildFood(ArrayList<Food> list) {
		int x = -1;
		do {
			util.clear();
			foodMenu();
			System.out.print("Choose >> ");
			x = util.ScanInt();
			if (x == 0) {
				return;
			}
		} while (x < 1 || x > 3);
		FoodFactory fs = FoodFactory.getFoodFactory();
		list.add(fs.MakeFood(x));
	}
}