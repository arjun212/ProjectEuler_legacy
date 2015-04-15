package problem24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Answer = 2783915460

public class Problem24 {

	public static int factorial(int x) {
		if (x < 2) {
			return 1;
		} else {
			return x * factorial(x-1);
		}
	}
	
	public static void main(String[] args) {
		int target = 1000000;
		List<Integer> digits = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
		int originalDigitsLength = digits.size();
		int factNumber = 9;
		boolean notReached = true;
		int digFound = 0;
		String result = "";
		
		while (notReached) {
			for (int i = 0; i < 10; i++) {
				if (i * factorial(factNumber) >= target) {
					digFound = digits.get(i-1);
					target -= (i-1) * factorial(factNumber);
					factNumber--;
					digits.remove(i-1);
					result += digFound;
					if (result.length() == originalDigitsLength) notReached = false;
					break;
				}
				
			}
		}
		System.out.println(result);
		
	}

}
