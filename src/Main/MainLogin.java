package Main;

import java.util.ArrayList;
import java.util.Scanner;
import Models.*;
import Models.Customer.*;
import Utils.*;
import Facades.*;

public class MainLogin {
	Scanner scan = new Scanner(System.in);
	private Controller CR = new Controller();
	private ArrayList<Food> foodList = null;
	private Utils util = new Utils();

	void menu(People trainer) {
		System.out.println("Welcome, " + trainer.getName());
		System.out.println("Logined at : " + util.getLocalTime());
		System.out.println("=======================");
		System.out.println("Chose your menu ");
		System.out.println("1. Order Food");
		System.out.println("2. View My Order");
		System.out.println("3. View Menu");
		System.out.println("4. Log out !");
	}

	public MainLogin(boolean OnApp, Customer Customer, ArrayList<People> list) {
		foodList = CR.getFoodRepo();
		while (OnApp) {
			int input = -1;
			util.clear();
			menu(Customer);
			do {
				System.out.print("Choose one >> ");
				input = util.ScanInt();
			} while (input > 4 || input < 1);
			switch (input) {
				case 1:
					CR.OrderMenu(foodList, Customer);
					break;
				case 2:
					CR.viewMyOrder(Customer.getListFood());
					break;
				case 3:
					CR.viewMenu(foodList);
					util.getchar();
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