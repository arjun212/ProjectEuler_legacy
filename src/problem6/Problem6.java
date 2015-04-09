package problem6;

//Answer = 25164150

public class Problem6 {

	public static int square(int x) {
		return x*x;
	}
	
	public static int sumN(int n) {
		//Sum from 1 to x
		return (n * (n+1)) / 2;
	}
	
	public static int sumNSquares(int n) {
		int acc = 0;
		for (int i = 1; i <= n; i++) {
			acc += square(i);
		}
		return acc;
	}
	
	public static void main(String[] args) {
		System.out.println(square(sumN(100)) - sumNSquares(100));
	}
	
}
