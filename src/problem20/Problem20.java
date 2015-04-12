package problem20;

import java.math.BigInteger;

//Answer = 648

public class Problem20 {

	public static BigInteger factorial(BigInteger x) {
		if (x.intValue() < 2) {
			return new BigInteger("1");
		} else {
			return x.multiply(factorial(x.subtract(new BigInteger("1"))));
		}
	}
	
	public static int sumDigits(String fact) {
		int acc = 0;
		for (int i = 0; i < fact.length(); i++) {
			acc += fact.charAt(i) - '0';
		}
		return acc;
	}

	public static void main(String[] args) {
		BigInteger fact = factorial(new BigInteger("100"));
		System.out.println(sumDigits(fact.toString()));
	}

}
