package Facades;

import java.util.*;
import Models.*;
import Models.Customer.*;

public class Controller {
	private Scanner scan = new Scanner(System.in);
	private Validasi valid = new Validasi();
//	private Utils util = new Utils();
//
	public void registerTrainer(ArrayList<People> list) {
		String username, password, Name;
		do {
			System.out.print("Input your name : ");
			Name = scan.nextLine();
		} while (!valid.checkName(Name));
		do {
			System.out.print("Input your ID/Username (Must be unique and min. 6 characters) [0 to exit]:  ");
			username = scan.nextLine();
			if (username.equals("0")) {
				return;
			}
			username = username.trim();
		} while (!valid.checkUsername(username, list));
		do {
			System.out.print("Input your Password (At least 6 character and must contains 1 Symbol) [0 to exit] : ");
			password = scan.nextLine();
			if (password.equals("0")) {
				return;
			}
		} while (!valid.checkPassword(password));
//		list.add(new Trainer(Name, username, password));
	}
  //Login Customer Or Admin
//	public void loginTrainer(ArrayList<Trainer> list, ArrayList<Pokemon> Pokelist) {
//		String username, password;
//		int index = -1;
//		do {
//			System.out.print("Input your ID/Username [0 to exit]:  ");
//			username = scan.nextLine();
//			if (username.equals("0")) {
//				return;
//			}
//			System.out.print("Input your Password :  ");
//			password = scan.nextLine();
//			index = valid.checkID(username, password, list);
//		} while (index == -1);
//		new MainLogin(true, list.get(index), Pokelist);
//	}

	// Add Order Food
//	public void AddPokemon(ArrayList<Pokemon> list, Trainer trainer) {
//		printPokemonList(list);
//		String input = "";
//		int index = -1;
//		do {
//			System.out.println(list.size());
//			System.out.print("Choose your Pokemon (Use Pokemon ID or Name to Choose) : ");
//			input = scan.nextLine();
//			index = valid.checkPokemon(list, input);
//		} while (index == -1);
//		int size = trainer.getPokeList().size();
//		if (trainer.lvl > size) {
//			int success = trainer.AddPokeList(list.get(index - 1));
//			if (success == 1) {
//				System.out.println("Pokemond Added !");
//				scan.nextLine();
//			} else if (success == -2) {
//				System.out.println("Can't add more than 3 pokemon !");
//				scan.nextLine();
//			} else {
//				System.out.println("Can't add the same Pokemon !!");
//				scan.nextLine();
//			}
//		} else {
//			System.out.println("You can't add more pokemon (need to lvl up !) ");
//			scan.nextLine();
//		}
//	}

	// Print My OrderList
//	public void printPokemonList(ArrayList<Pokemon> list) {
//		int index = 1;
//		System.out.println("\tAll Pokemon");
//		System.out.println("=============================");
//		for (Pokemon pokemon : list) {
//			System.out.println("Pokemon ID      : " + index++);
//			System.out.println("Pokemon Name    : " + pokemon.getName());
//			System.out.println("Pokemon HP      : " + pokemon.getHp());
//			System.out.println("Pokemon Agility : " + pokemon.getAgl());
//			System.out.println("Pokemon Damage  : " + pokemon.getAtt());
//			System.out.println("Pokemon Defense : " + pokemon.getDef());
//			System.out.println("Pokemon Level   : " + pokemon.getLvl());
//			System.out.println("=============================");
//		}
//	}
	
//	public void clear() {
//		for (int i = 0; i < 30; i++) {
//			System.out.println();
//		}
//	}
//
//	public void FirePokemon(FirePokemon getEnemey, Pokemon get) {
//		Random ran = new Random();
//		int random = valid.randomize();
//		if (random <= 5) {
//			System.out.println("Pokemon have appear !");
//			System.out.println("====================");
//			System.out.println("Enemey          : " + getEnemey.getName());
//			System.out.println("Enemey Attack   : " + (getEnemey.getAtt() * getEnemey.getLvl()) * 0.8);
//			System.out.print("Enemey Skill    : ");
//			getEnemey.Skill();
//			System.out.println("Enemey Level    : " + (ran.nextInt(get.getLvl()) + 1) * 1.2);
//			System.out.println("Continue....");
//		} else if (random > 5 && random <= 10) {
//			System.out.println("Wild Pokemon have appear !");
//			System.out.println("====================");
//			System.out.println("Enemey          : " + getEnemey.getName());
//			System.out.println("Enemey Attack   : " + (getEnemey.getAtt() * getEnemey.getLvl()) * 1.6);
//			System.out.print("Enemey Skill    : ");
//			getEnemey.Skill();
//			System.out.println("Enemey Level    : " + (ran.nextInt(get.getLvl()) + 1) * 1.5);
//			getEnemey.tails();
//			System.out.println("Continue....");
//		}
//	}
//
//	public void WaterPokemon(WaterPokemon getEnemey, Pokemon get) {
//		Random ran = new Random();
//		int random = valid.randomize();
//		if (random <= 5) {
//			System.out.println("Pokemon have appear !");
//			System.out.println("====================");
//			System.out.println("Enemey          : " + getEnemey.getName());
//			System.out.println("Enemey Attack   : " + (getEnemey.getAtt() * getEnemey.getLvl()) * 1.7);
//			System.out.print("Enemey Skill    : ");
//			getEnemey.Skill();
//			System.out.println("Enemey Level    : " + (ran.nextInt(get.getLvl()) + 1) * 1.7);
//			System.out.println("Continue....");
//
//		} else if (random > 5 && random <= 10) {
//			System.out.println("Wild Pokemon have appear !");
//			System.out.println("====================");
//			System.out.println("Enemey          : " + getEnemey.getName());
//			System.out.println("Enemey Attack   : " + (getEnemey.getAtt() * getEnemey.getLvl()) * 1.9);
//			System.out.print("Enemey Skill    : ");
//			getEnemey.Skill();
//			System.out.println("Enemey Level    : " + (ran.nextInt(get.getLvl()) + 1) * 1.9);
//			getEnemey.sirip();
//			System.out.println("Continue....");
//		}
//	}
//
//	public void enemeyRandom(ArrayList<Pokemon> PokemonLists) {
//		Random ran = new Random();
//		int index = ran.nextInt(PokemonLists.size());
//		Pokemon get = PokemonLists.get(index);
//		FirePokemon getEnemey;
//		WaterPokemon getEnemey1;
//		if (get.getType().equals("Fire")) {
//			getEnemey = (FirePokemon) get;
//			FirePokemon(getEnemey, get);
//			scan.nextLine();
//		} else {
//			getEnemey1 = (WaterPokemon) get;
//			WaterPokemon(getEnemey1, get);
//			scan.nextLine();
//		}
//	}
//
//	public void trainPokemon(Trainer trainer, ArrayList<Pokemon> PokemonLists) {
//		if (trainer.getPokeList().isEmpty()) {
//			viewMyPokemon(trainer);
//			return;
//		}
//		clear();
//		enemeyRandom(PokemonLists);
//		printMyPokemon(trainer);
//		String input = "";
//		int index = -1;
//		ArrayList<Pokemon> list = trainer.getMyPokelist();
//		do {
//			System.out.print("Use Pokemon ID or Name to Choose [0  to exit]  >> ");
//			input = scan.nextLine();
//			index = valid.checkPokemon(list, input);
//			if (input.equals("0")) {
//				return;
//			}
//			if (index > -1) {
//				if (list.get(index - 1).getHp() > 0) {
//					break;
//				}
//				System.out.println("Cant use dead pokemon ! ");
//			}
//		} while (true);
//		clear();
//		new Battle(true, list.get(index - 1), trainer);
//	}
//
//	public void printMyPokemon(Trainer trainer) {
//		ArrayList<Pokemon> list = trainer.getPokeList();
//		int index = 1;
//		System.out.println("Choose your pokemon for battle !");
//		System.out.println("================================");
//		for (Pokemon pokemon : list) {
//			if (pokemon.getHp() > 0) {
//				System.out.println(index++ + ". " + pokemon.getName() + " ( element : " + pokemon.getType() + " )");
//			} else {
//				System.out.println(index++ + ". " + pokemon.getName() + " ( need Healing ! ) ");
//			}
//		}
//	}
//
//	public void viewMyPokemon(Trainer trainer) {
//		util.clear();
//		if (trainer.getPokeList().isEmpty()) {
//			System.out.println("You don't have any pokemon !! ");
//			scan.nextLine();
//			return;
//		}
//		ArrayList<Pokemon> list = trainer.getPokeList();
//		int num = 1;
//		System.out.println("=====================");
//		for (Pokemon pokemon : list) {
//			System.out.println(num++ + ". " + pokemon.getName());
//		}
//		System.out.println("=====================");
//		scan.nextLine();
//	}
//
//	public void Att(Pokemon mypokemon, Trainer trainer) {
//		util.clear();
//		if (mypokemon.getType().equals("Fire")) {
//			mypokemon = (FirePokemon) mypokemon;
//		} else {
//			mypokemon = (WaterPokemon) mypokemon;
//		}
//		System.out.println("Your pokemon damage " + mypokemon.getAtt());
//		scan.nextLine();
//		int result = valid.randomize();
//		if (result >= 0 && result <= 5) {
//			System.out.println("You Lose !");
//			System.out.print(mypokemon.getName() + " Has Died !");
//			scan.nextLine();
//			mypokemon.setHp(0);
//		} else {
//			mypokemon.setHp(mypokemon.getHp() / 2);
//			mypokemon.setExp(mypokemon.getAtt() * 2);
//			trainer.setLvl(trainer.getLvl() + 1);
//			System.out.println("Icredible !");
//			System.out.println("Now you can add more pokemon");
//			System.out.println("Your Pokemon Gain EXP !");
//			scan.nextLine();
//		}
//	}
//
//	public void Att(Pokemon mypokemon, double skillDamage, Trainer trainer) {
//		util.clear();
//		if (mypokemon.getType().equals("Fire")) {
//			mypokemon = (FirePokemon) mypokemon;
//		} else {
//			mypokemon = (WaterPokemon) mypokemon;
//		}
//		System.out.println("Pokemon skill" + " " + skillDamage);
//		scan.nextLine();
//		int result = valid.randomize();
//		if (result == 0) {
//			System.out.println("Better Luck Next Time ..");
//			System.out.println(mypokemon.getName() + " Has Died !");
//			scan.nextLine();
//			mypokemon.setHp(0);
//		} else {
//			mypokemon.setHp(mypokemon.getHp() / 2);
//			mypokemon.setExp(mypokemon.getAtt() * 2);
//			mypokemon.setAtt(mypokemon.getAtt() * 2);
//			mypokemon.setAgl(mypokemon.getAgl() * 2);
//			trainer.setLvl(trainer.getLvl() + 1);
//			System.out.println("Flawless !");
//			System.out.println("Now you can add more pokemon");
//			System.out.println("Your Pokemon Gain EXP !");
//			scan.nextLine();
//		}
//	}
//
//	public void HealPokemon(Trainer trainer) {
//		boolean flag = false;
//		Random ran = new Random();
//		int index = 1;
//		ArrayList<Pokemon> list = trainer.getPokeList();
//		for (Pokemon pokemon : list) {
//			if (pokemon.getHp() < 1) {
//				System.out.println(index++ + ". " + pokemon.getName());
//				flag = true;
//			}
//		}
//		if (!flag) {
//			System.out.println("There no pokemon to heal");
//			return;
//		}
//		String name = "";
//		int idx = -1;
//		do {
//			System.out.print("Input pokemon name to heal [0 Exit] : ");
//			name = scan.nextLine();
//			if (name.equals("0")) {
//				return;
//			}
//			idx = valid.checkHeal(name, list);
//		} while (idx == -1);
//		Pokemon PokemonTarget = list.get(idx);
//		PokemonTarget.setHp(ran.nextInt(31) + 1);
//		System.out.println("Your Pokemon Has been healed ");
//		scan.nextLine();
//	}
}
