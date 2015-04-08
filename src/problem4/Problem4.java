package problem4;

//Answer = 906609

public class Problem4 {

	public static boolean isPalindrome(String x) {
		if (x.length() < 2) {
			return true;
		} else if (x.length() == 2) {
			return (x.charAt(0) == x.charAt(1));
		} else if (x.charAt(0) == x.charAt(x.length()-1)) {
			return isPalindrome(x.substring(1, x.length() - 1));
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int biggestProd = 0;
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > i; j--) {
				int prod = i * j;
				if (isPalindrome(String.valueOf(prod)) && (biggestProd < prod)) {
					biggestProd = prod;
				}
			}
		}

		System.out.println(biggestProd);
	}
}
