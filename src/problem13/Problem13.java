package problem13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem13 {

	static ArrayList<String> numbers = new ArrayList<String>();

	static StringBuilder result = new StringBuilder();
	
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
			if (s.length() != 1) {
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
			carry += numbers.get(i).charAt(numbers.get(i).length()-1) - '0';
			numbers.set(i, numbers.get(i).substring(0, numbers.get(i).length()-1));
			
		}
		result.append(getUnits(carry));
		carry = getSD(carry);
		System.out.println(carry);
		}
		System.out.println(result.toString());
		
	}

}
