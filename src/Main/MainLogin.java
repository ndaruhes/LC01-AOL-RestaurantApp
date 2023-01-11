package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Models.*;
import Models.Customer.*;
import Repository.*;
import Utils.*;
import Facades.*;

public class MainLogin {

	Scanner scan = new Scanner(System.in);
	LocalDate LocalTime = LocalDate.now();
	private Controller CR = new Controller();

	void menu(People trainer) {
		System.out.println("Welcome, " + trainer.getName());
		System.out.println("Logined at : " + LocalTime);
		System.out.println("=======================");
		System.out.println("Chose your menu ");
		System.out.println("1. Order Food");
		System.out.println("2. View My Order");
		System.out.println("3. View Menu");
		System.out.println("4. Log out !");
	}

	void clear() {
		for (int i = 0; i < 15; i++) {
			System.out.println();
		}
	}

	public MainLogin(boolean OnApp, People trainer, ArrayList<People> list) {
		while (OnApp) {
			int input = -1;
			clear();
			menu(trainer);
			do {
				System.out.print("Choose one >> ");
				try {
					input = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
					System.out.print("Input must be numeric ! ");
				}
			} while (input > 5 || input < 1);
			switch (input) {
			case 1:
				
				break;
			case 2:
//				CR.trainPokemon(trainer, list);
				break;
			case 3:
//				CR.viewMyPokemon(trainer);
				break;
			case 4:
//				CR.HealPokemon(trainer);
				break;
			case 5:
				OnApp = !OnApp;
				return;
			default:
			}
		}
	}

}
