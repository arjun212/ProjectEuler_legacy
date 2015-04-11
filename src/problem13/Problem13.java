package problem13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Answer = 5537376230

public class Problem13 {

	static ArrayList<String> numbers = new ArrayList<String>();

	static String result = "";

	public static void importData() throws FileNotFoundException {
		File file = new File("./src/problem13/data");
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			numbers.add(sc.nextLine());
		}
		sc.close();
	}

	public static int getUnits(int x) {
		return x % 10;
	}

	public static int getSD(int x) {
		return (x - (x % 10)) / 10;
	}

	public static boolean numbersEmpty() {
		for (String s : numbers) {
			if (s.length() != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws FileNotFoundException {
		importData();
		int carry = 0;
		while (!numbersEmpty()) {
			for (int i = 0; i < numbers.size(); i++) {
				String num = numbers.get(i);
				carry += numbers.get(i).charAt(num.length() - 1) - '0';
				numbers.set(i, num.substring(0, num.length() - 1));
			}
			result = (getUnits(carry)) + result;
			carry = getSD(carry);
		}
		result = String.valueOf(carry) + result.toString();
		result = result.substring(0, 10);
		System.out.println(result.toString());

	}

}
