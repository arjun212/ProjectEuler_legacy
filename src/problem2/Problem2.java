package problem2;

//Answer = 4613732

public class Problem2 {

	public static void main(String[] args) {
		int acc = 2;
		int firstFib = 1;
		int secondFib = 2;
		int nextFib = firstFib + secondFib;
		while (nextFib < 4000000) {
			System.out.println(nextFib);
			if (nextFib%2 == 0) {
				acc += nextFib;
			}
			firstFib = secondFib;
			secondFib = nextFib;
			nextFib = firstFib + secondFib;
		}
		System.out.println(acc);
	}
}
