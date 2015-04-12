package problem21;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//Answer = 31626

public class Problem21 {

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
	
	public static boolean isAmicable(int a) {
		return ((d(d(a)) == a) && (d(a) != a));
	}
	
	public static void main(String[] args) throws InterruptedException {
		Set<Integer> amicableNumbers = new HashSet<Integer>();
		for (int i = 2; i < 10000; i++) {
				if (isAmicable(i)) {
					amicableNumbers.add(i);
				}
		}

		int acc = 0;
		for (Integer i : amicableNumbers) {
			acc += i;
		}
		System.out.println(acc);
	}
	
	
}
