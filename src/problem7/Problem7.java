package problem7;

//Answer = 104743

public class Problem7 {
	
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
		int count = 1;
		int prime = 2;
		while (count < 10001) {
			count++;
			prime = nextPrime(prime);
		}
		System.out.println(prime);
	}
}
