package problem38;

import java.util.ArrayList;
import java.util.List;

//Answer = 932718654

public class Problem38 {

	public static void main(String[] args) {
		int largestPandigital = 0;
		List<PanSet> superSet = new ArrayList<PanSet>();
		for (int i = 2; i < 10; i++) {
			superSet.add(new PanSet(i));
		}
		for (PanSet p : superSet) {
			for (int i = p.bottomBoundary; i <= p.topBoundary; i++) {
				if ((p.createsPandigital(i)) && (largestPandigital < Integer.parseInt(p.panResult(i)))) {
					largestPandigital = Integer.parseInt(p.panResult(i));
				}
			}
		}
		System.out.println(largestPandigital);
	}

}
