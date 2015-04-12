package problem22;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Answer = 871198282

public class Problem22 {

	public static List<String> importData() throws FileNotFoundException {
		String filename = "./src/problem22/data";
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		sc.useDelimiter(",");
		ArrayList<String> result = new ArrayList<String>();
		while (sc.hasNext()) {
			String s = sc.next();
			s = s.replace("\"", "");
			result.add(s);
		}
		sc.close();
		return result;
	}
	
	public static int alphabetScore(String name) {
		int acc = 0;
		for (int i = 0; i < name.length(); i++) {
			acc += name.charAt(i) - 'A' + 1;
		}
		return acc;
	}
	
	public static int nameScore(List<String> data, String name) {
		int posScore = data.indexOf(name) + 1;
		int alphScore = alphabetScore(name);		
		return alphScore * posScore;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		List<String> data = importData();
		java.util.Collections.sort(data);
		BigInteger acc = new BigInteger("0");
		for (String s : data) {
			acc = acc.add(new BigInteger(String.valueOf(nameScore(data, s))));
		}
		System.out.println(acc);
		
	}
	
}
