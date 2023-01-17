package Main;

import java.util.ArrayList;
import java.util.Scanner;
import Models.*;
import Models.Customer.*;
import Utils.*;
import Facades.*;

public class MainAdmin {
	Scanner scan = new Scanner(System.in);
	private Controller CR = new Controller();
	private ArrayList<Food> foodList = null;
	private Utils util = new Utils();

	void menu(People admin) {
		System.out.println("Welcome, Admin : " + admin.getName());
		System.out.println("Logined at : " + util.getLocalTime());
		System.out.println("=======================");
		System.out.println("Chose your menu ");
		System.out.println("1. Create Menu");
		System.out.println("2. View All Order");
		System.out.println("3. View Customer Order");
		System.out.println("4. Log out !");
	}

	public MainAdmin(boolean OnApp, Admin Admin, ArrayList<People> list) {
		foodList = CR.getFoodRepo();
		while (OnApp) {
			int input = -1;
			util.clear();
			menu(Admin);
			do {
				System.out.print("Choose one >> ");
				input = util.ScanInt();
			} while (input > 3 || input < 1);
			switch (input) {
			case 1:
				CR.buildFood(foodList);
				break;
			case 2:
				CR.print_customer_ordered(list, Admin);
				break;
			case 3:
				CR.ViewAllOrder(list, Admin);
				break;
			case 4:
				OnApp = !OnApp;
				return;
			default:
				break;
			}
		}
	}

}
