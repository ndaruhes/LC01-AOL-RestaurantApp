package Facades;

import java.util.*;
import Models.*;
import Models.Customer.*;

public class Validasi {
	public boolean checkUsername(String ID, ArrayList<People> list) {
		if (ID.length() >= 6) {
			for (People x : list) {
				if (x.getUsername().equals(ID)) {
					System.out.println("Username Already Exists ! ");
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean checkAddress(String address) {
		if (address.length() >= 6) {
			return true;
		}
		System.out.println("Addres Must be at least 6 Character !! ");
		return false;
	}

	public boolean checkAge(int age) {
		if (age > 5) {
			return true;
		}
		System.out.println("This App Not For Kids (Must Be at least 6 years old) ");
		return false;
	}

	public boolean checkName(String Name) {
		if (Name.length() > 3) {
			return true;
		} else if (Name.equals(" ")) {
			System.out.println("Name can't be null");
			return false;
		}
		System.out.println("Name can't less than 3 characters ! ");
		return false;
	}

	public boolean checkPassword(String Pass) {
		if (Pass.length() >= 6) {
			boolean isValidPassword = false;
			String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			for (int i = 0; i < Pass.length(); i++) {
				if (character.contains(Character.toString(Pass.charAt(i)))) {
					isValidPassword = true;
					break;
				}
			}
			if (!isValidPassword) {
				System.out.println("Password must have at least one aphabet !");
				return false;
			}
			String symbol = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
			for (int i = 0; i < symbol.length(); i++) {
				char ch = symbol.charAt(i);
				if (Pass.contains(Character.toString(ch))) {
					return true;
				}
			}
			System.out.println("Password must have at least one symbol !");
			return false;
		}
		System.out.println("Password must at lest 6 characters !");
		return false;
	}

	public int checkID(String ID, String Pass, ArrayList<People> list) {
		int i = 0;
		for (People x : list) {
			if (x.getUsername().equals(ID)) {
				if (x.getPassword().equals(Pass)) {
					return i;
				} else {
					System.out.println("Password or Username wrong !! ");
					return -1;
				}
			}
			i++;
		}
		System.out.println("Username not found !");
		return -1;
	}

	// Buat Check Order Food
	public int checkFood(ArrayList<Food> list, String FoodName) {
		int id;
		try {
			id = Integer.parseInt(FoodName);
			if (id < 1 || id > list.size()) {
				System.out.println("Menu ID not found !");
				return -1;
			}
			return id;
		} catch (Exception e) {

		}
		int index = 1;
		for (Food pokemon : list) {
			if (pokemon.getFoodName().equals(FoodName)) {
				return index;
			}
			index++;
		}
		System.out.println("Menu not found ! ");
		return -1;
	}

//	public int randomize() {
//		Random r = new Random();
//		return r.nextInt(10);
//	}
}
