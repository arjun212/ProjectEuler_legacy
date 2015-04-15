package problem30;

//Answer = 443839

public class Problem30 {

	public static int sumPowDigits(String num, int exp) {
		int acc = 0;
		for (int i = 0; i < num.length(); i++) {
			acc += Math.pow(num.charAt(i) - '0', exp);
		}
		return acc;
	}
	
	public static boolean canBeWritten(int num) {
		if (num > 9) {
		return (sumPowDigits(String.valueOf(num), 5) == num);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int acc = 0;
		for (int i = 0; i < 200000; i++) {
			if (canBeWritten(i)) {
				acc += i;
			}
		}
		System.out.println(acc);
	}
	
}
