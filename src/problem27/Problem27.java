package problem27;

import java.util.ArrayList;

//Answer = -59231

public class Problem27 {
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

	public static ArrayList<Integer> primeList(int topBound) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < topBound; i++) {
			if (isPrime(i)) {
				result.add(i);
			}
		}
		return result;
	}

	public static int equation(int a, int b, int n) {
		return (n * n) + (a * n) + b;
	}

	public static ArrayList<Integer> conPrimeLength(int a, int b) {
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(0);
		result.add(0);
		while (isPrime(equation(a, b, n1))) {
			n1++;
		}
		if (result.get(2) < n1) {
			result.set(0, a);
			result.set(1, b);
			result.set(2, n1);
		}
		
		while (isPrime(equation(-a, b, n2))) {
			n2++;
		}
		if (result.get(2) < n2) {
			result.set(0, -a);
			result.set(1, b);
			result.set(2, n2);
		}
		
		while (isPrime(equation(a, -b, n3))) {
			n3++;
		}
		if (result.get(2) < n3) {
			result.set(0, a);
			result.set(1, -b);
			result.set(2, n3);
		}
		
		while (isPrime(equation(-a, -b, n4))) {
			n4++;
		}
		if (result.get(2) < n4) {
			result.set(0, -a);
			result.set(1, -b);
			result.set(2, n4);
		}
		
		return result;
	}

	public static void main(String[] args) {
		int finalA = 0;
		int finalB = 0;
		int biggestLength = 0;
		ArrayList<Integer> primes = primeList(1000);
		for (Integer i : primes) {
			for (Integer j : primes) {
				ArrayList<Integer> res = conPrimeLength(i,j);
				if (biggestLength < res.get(2)) {
					finalA = res.get(0);
					finalB = res.get(1);
					biggestLength = res.get(2);
				}
			}
		}
		System.out.println(finalA*finalB);
	}
}
