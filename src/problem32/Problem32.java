package problem32;

import java.util.HashSet;
import java.util.Set;

//Answer = 45228

public class Problem32 {

	public static boolean isPan(String x) {
		if (x.length() != 9) {
			return false;
		} else {
			for (int i = 1; i < 10; i++) {
				if (!x.contains(String.valueOf(i))) {
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Set<Integer> prods = new HashSet<Integer>();
		int acc = 0;
		for (int i = 0; i < 3000; i++) {
			for (int j = i; j < 3000; j++) {
				int prod = i * j;
				StringBuilder sb = new StringBuilder();
				sb.append(i);
				sb.append(j);
				sb.append(prod);
				if (isPan(sb.toString())) {
					if (prods.add(prod)) {
						acc += prod;
					}
				}
			}
		}
		System.out.println(acc);
	}

}
