package problem3;

import java.util.HashSet;
import java.util.Set;

//Answer = 4613732

public class Problem3 {
	
	static boolean isPrime(Integer x) {
		return false;
	}
	
	static boolean isFactor(Integer x, Integer y) {
		return (x % y == 0);
	}
	
	static Set<Integer> getPrimeFactors(Integer x) {
		HashSet<Integer> result = new HashSet<Integer>();
		for (int i = 2; i < x/2; i++) {
			if (isPrime(i) && isFactor(x,i)) {
				result.add(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
	}
}
