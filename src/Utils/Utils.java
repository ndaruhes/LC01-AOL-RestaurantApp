package Utils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class Utils {
	final String ANSI_RED = "\u001B[31m";
	final String TEXT_GREEND = "\u001B[32m";
	final String ANSI_RESET = "\u001B[0m";
	Calendar calndr = Calendar.getInstance();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	DecimalFormat ft = new DecimalFormat("#");

	public LocalDate getLocalTime() {
		return LocalDate.now();
	}

	public int ScanInt() {
		int idx = -1;
		try {
			idx = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			System.out.println("Input must be a numeric !");
			scan.nextLine();
		}
		return idx;
	}

	public void clear() {
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}
	}

	public String RandomChar(int random) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String str2 = "";
		int length = str.length();
		for (int i = 0; i < random; i++) {
			str2 += str.indexOf(Random(length));
		}
		return str2;
	}

	public String ScanLine() {
		String str = scan.nextLine();
		return str;
	}

	public void getchar() {
		scan.nextLine();
	}

	public int Random(int value) {
		int ran;
		ran = rand.nextInt(value);
		return ran;
	}
}
