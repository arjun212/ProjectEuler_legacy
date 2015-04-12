package problem23;

import java.util.Set;
import java.util.TreeSet;

public class Problem23 {
	
	public static Set<Integer> getDivisors(int x) {
		Set<Integer> result = new TreeSet<Integer>();
		result.add(1);
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				result.add(i);
				result.add(x / i);
			}
		}
		return result;
	}
	
	public static int d(int x) {
		Set<Integer> divisors = getDivisors(x);
		int acc = 0;
		for (Integer i : divisors) {
			acc += i;
		}
		return acc;
	}
	
	public static boolean isAbundant(int a) {
		return (d(a) > a);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if (isAbundant(i)) System.out.println(i);
		}
	}
	
}
