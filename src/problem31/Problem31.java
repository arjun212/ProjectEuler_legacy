package problem31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Answer = 73682
//http://www.mathblog.dk/project-euler-31-combinations-english-currency-denominations/

public class Problem31 {

	static List<Integer> denoms = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200));
	
	public static void main(String[] args) {
		int[] ways = new int[200+1];
		ways[0] = 1;
		for (int i = 0; i < denoms.size(); i++) {
			for (int j = denoms.get(i); j <= 200; j++) {
				ways[j] += ways[j - denoms.get(i)];
			}
		}
		System.out.println(ways[200]);
	}
	
}
