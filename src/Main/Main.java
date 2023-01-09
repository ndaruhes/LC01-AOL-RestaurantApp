package Main;

import Utils.*;
import java.util.*;
import Facades.*;
import Models.*;

public class Main {
	public Utils util = new Utils();
	private Controller CR = new Controller();
	private ArrayList<Food> FoodList = new ArrayList<Food>();
	void menu() {
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
	}

	public Main(boolean onApp) {
		while (onApp) {
			int input = -1;
			util.clear();
			menu();
			do {
				System.out.print("Choose One >> ");
				input = util.ScanInt();
			} while (input > 3 || input < 1);
			switch (input) {
			case 1:
				
				break;
			case 2:
				CR.registerTrainer(null);
				break;
			case 3:
				onApp = !onApp;
				break;
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		new Main(true);
	}

}