package problem1;

//Answer = 233168

public class Problem1 {

	public static void main(String[] args) {
		int acc = 0;
		for (int i = 0; i < 1000; i++) {
			if ((i % 3 == 0) || (i%5 == 0)) {
				acc += i;
			}
		}
		System.out.println(acc);
	}
}
