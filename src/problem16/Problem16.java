package problem16;

import java.math.BigInteger;

//Answer = 1366

public class Problem16 {

	public static String power(int base, int exp) {
		BigInteger x = new BigInteger(String.valueOf(base));
		x = x.pow(exp);
		return x.toString();
	}
	
	public static int countDigits(String x) {
		int acc = 0;
		for (int i = 0; i < x.length(); i++) {
			acc += (x.charAt(i)- '0');
		}
		return acc;
	}
	
	public static void main(String[] args) {	
		System.out.println(countDigits(power(2,1000)));
	}
	
}
