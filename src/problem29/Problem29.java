package problem29;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

//Answer = 9183

public class Problem29 {

	public static String power(int a, int b) {
		BigInteger aBig = new BigInteger(String.valueOf(a));
		return aBig.pow(b).toString();
	}
	
	public static void main(String[] args) {
		Set<String> result = new TreeSet<String>();
		for (int a = 2; a <= 100; a++) {
			for (int b = a; b <= 100; b++) {
				result.add(power(a,b));
				result.add(power(b,a));
			}
		}
		System.out.println(result.size());
	}
	
}
