package Facades;

import java.util.*;

import Builder.BurgerBuilder;
import Builder.HotdogBuilder;
import Builder.PizzaBuilder;
import Factory.FoodFactory;
import Models.*;
import Models.Customer.*;
import Repository_Singleton.FoodRepository;
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
		System.out.printf("%-26s All Menu %-26s\n", " ", " ");
		System.out.println("=".repeat(60));
		System.out.printf("| %-3s | %-20s | %-10s | %-14s |\n", "No", "Food", "Price", "Category");
		System.out.println("=".repeat(60));
		int x = 1;
		for (Food food : foodList) {
			System.out.printf("| %-3d ", x++);
			food.printFood();
		}
		System.out.println("=".repeat(60));
	}

	public void viewMyOrder(ArrayList<Food> foodList) {
		if (foodList.isEmpty()) {
			System.out.println("No Menu Has Ordered !");
			util.getchar();
			return;
		}
		System.out.printf("%-23s Ordered Menu %-23s\n", " ", " ");
		System.out.println("=".repeat(60));
		System.out.printf("| %-3s | %-20s | %-10s | %-14s |\n", "No", "Food", "Price", "Category");
		System.out.println("=".repeat(60));
		int x = 1;
		for (Food food : foodList) {
			System.out.printf("| %-3d ", x++);
			food.printFood();
		}
		System.out.println("=".repeat(60));
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
		util.clear();
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

	public void builCustomFood(ArrayList<Food> list) {
		int x = -1, price = -1;
		String name;
		do {
			util.clear();
			System.out.println("Choose Category");
			System.out.println("===============");
			foodMenu();
			System.out.println("4. Back");
			System.out.print("Choose >> ");
			x = util.ScanInt();
			if (x == 0 || x == 4) {
				return;
			}
		} while (x < 1 || x > 3);

		do {
			System.out.print("Input Food Name [0 To Exit] : ");
			name = util.ScanLine();
			if (x == 0) {
				return;
			}
		} while (!valid.checkFoodLenght(name));

		do {
			System.out.print("Input Food Price [0 To Exit] : ");
			price = util.ScanInt();
			if (x == 0) {
				return;
			}
		} while (!valid.checkFoodPrice(price));
		Food food = null;
		switch (x) {
		case 1:
			food = buildBurger(name, price);
			break;
		case 2:
			food = buildPizza(name, price);
			break;
		case 3:
			food = buildHotdog(name, price);
			break;
		}
		list.add(food);
		System.out.println(name + " Has Been Created !");
		System.out.println("Press Enter To Continue ....");
		util.getchar();
	}

	Food buildBurger(String name, int price) {
		BurgerBuilder burgerBuilder = new BurgerBuilder();
		Food burger = burgerBuilder.reset().buildName(name).buildPrice(price).getFood();
		return burger;
	}

	Food buildPizza(String name, int price) {
		PizzaBuilder PizzaBuilder = new PizzaBuilder();
		Food Pizza = PizzaBuilder.reset().buildName(name).buildPrice(price).getFood();
		return Pizza;
	}

	Food buildHotdog(String name, int price) {
		HotdogBuilder HotdogBuilder = new HotdogBuilder();
		Food HotDog = HotdogBuilder.reset().buildName(name).buildPrice(price).getFood();
		return HotDog;
	}
}