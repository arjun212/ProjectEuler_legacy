package problem38;

import java.util.ArrayList;
import java.util.List;

public class PanSet {

	List<Integer> set;
	int bottomBoundary = 0;
	int topBoundary = 0;

	public PanSet(int x) {
		set = new ArrayList<Integer>();
		for (int i = 1; i <= x; i++) {
			set.add(i);
		}
		findBottomBoundary();
		findTopBoundary();
	}

	public String panResult(int x) {
		StringBuilder sb = new StringBuilder();
		for (Integer i : set) {
			sb.append(i*x);
		}
		return sb.toString();
	}
	
	public int sizePanResult(int x) {
		return panResult(x).length();
	}
	
	public boolean createsPandigital(int x) {
		if ((sizePanResult(x) == 9)) {
			String s = panResult(x);
			int count = 0;
			for (int i = 1; i < 10; i++) {
				if (s.contains(String.valueOf(i))) {
					count++;
				}
			}
			return (count == 9);
		}
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (int i = 0; i < set.size() - 1; i++) {
			sb.append(set.get(i) + ", ");
		}
		sb.append(set.get(set.size() - 1) + " }");
		return sb.toString();
	}

	public void findBottomBoundary() {
		int i = 0;
		while (sizePanResult(i) < 9) {
			i++;
		}
		bottomBoundary = i;
	}
	
	public void findTopBoundary() {
		int i = bottomBoundary;
		while (sizePanResult(i) == 9) {
			i++;
		}
		topBoundary = i - 1;
	}

}
