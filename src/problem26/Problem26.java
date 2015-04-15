package problem26;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

//Answer = 983

public class Problem26 {

	public static String getRecurring(int x) {
		int numerator = 10;
		LinkedHashMap<Integer, Integer> decimals = new LinkedHashMap<Integer, Integer>(); 
		while (!decimals.containsKey((numerator % x))) {
			Integer key = numerator%x;
			Integer value = (int) Math.floor(numerator / (double)x);
			numerator = key * 10;
			decimals.put(key, value);
		}
		Integer key = numerator%x;
		Integer value = (int) Math.floor(numerator / (double)x);
		decimals.put(key, value);
		
		StringBuilder sb = new StringBuilder();
		Set<Entry<Integer, Integer>> eset = decimals.entrySet();
		boolean found = false;
		for (Entry<Integer, Integer> e : eset) {
			if (found || (e.getKey() == (numerator % x))) {
				found = true;
				sb.append(e.getValue());
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args)  {
		int biggestRecurrence = 0;
		int biggestIndex = 0;
		for (int i = 2; i < 1000; i++) { 
			if (biggestRecurrence < getRecurring(i).length()) {
				biggestRecurrence = getRecurring(i).length();
				biggestIndex = i;
			}
		}
		System.out.println(biggestIndex);
	}
	
}
