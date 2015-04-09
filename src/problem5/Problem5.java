package problem5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Answer = 232792560

public class Problem5 {

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

	public static ArrayList<Integer> findPrimeFactors(int x) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (isPrime(x)) {
			result.add(x);
			return result;
		} else {
			int i = nextPrime(1);
			while (x % i != 0) {
				i = nextPrime(i);
			}
			result.add(i);
			result.addAll(findPrimeFactors(x / i));
			return result;
		}
	}

	public static int count(List<Integer> factorsList, int factor) {
		int count = 0;
		for (Integer i : factorsList) {
			if (i == factor) {
				count++;
			}
		}
		return count;
	}

	public static List<Integer> maxSet(List<List<Integer>> allFactorsList,
			int factor) {
		int max = 0;
		List<Integer> maxList = null;
		for (List<Integer> L : allFactorsList) {
			if (max < count(L, factor)) {
				maxList = L;
				max = count(L, factor);
			}
		}
		return maxList;
	}

	public static int prodList(List<Integer> list) {
		int acc = 1;
		for (Integer i : list) {
			acc *= i;
		}
		return acc;
	}

	public static void main(String[] args) {
		Set<Integer> allFactorsSet = new HashSet<Integer>();
		List<List<Integer>> allFactorsList = new ArrayList<List<Integer>>();
		for (int i = 2; i < 20; i++) {
			ArrayList<Integer> a = findPrimeFactors(i);
			allFactorsSet.addAll(a);
			allFactorsList.add(a);
		}
		List<Integer> finalList = new ArrayList<Integer>();
		for (Integer i : allFactorsSet) {
			finalList.addAll(maxSet(allFactorsList, i));
		}
		System.out.println(prodList(finalList));
	}

}
