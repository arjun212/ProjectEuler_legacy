package problem10;

import java.math.BigInteger;

//Answer = 142913828922

public class Problem10 {
	
	public static boolean isPrime(int x) {
		if (x < 2)
			return false;

		if (x == 2)
			return true;

		if (x % 2 == 0)
			return false;

		for (int i = 3; i * i <= x; i += 2) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	public static int nextPrime(int x) {
		int i = x;
		while (!isPrime(i + 1)) {
			i++;
		}
		return (i + 1);
	}
	
	public static void main(String[] args) {
		BigInteger acc = new BigInteger(Integer.toString(0));
		int prime = 0;
		while (prime < 2000000) {
			acc = acc.add(new BigInteger(Integer.toString(prime)));
			prime = nextPrime(prime);
		}
		System.out.println(acc);
	}
	
}
