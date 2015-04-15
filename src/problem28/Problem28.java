package problem28;

//Answer = 669171001

public class Problem28 {

	public static int sumLUDiag(int size) {
		int acc = 0;
		for (int i = 3; i <= size; i+=2) {
			acc += (i*i) - (i-1);
		}
		return acc;
	}
	
	public static int sumLDDiag(int size) {
		int acc = 0;
		for (int i = 2; i <= size; i+=2) {
			acc += (i*i) + 1;
		}
		return acc;
		
	}
	
	public static int sumRUDiag(int size) {
		int acc = 0;
		for (int i = 3; i <= size; i+=2) {
			acc += i*i;
		}
		return acc;
	}
	
	public static int sumRDDiag(int size) {
		int acc = 0;
		for (int i = 2; i <= size; i+=2) {
			acc += (i*i) - (i-1);
		}
		return acc;
		
	}
	
	public static void main(String[] args) {
		int result = 0;
		int size = 1001;
		result += sumLDDiag(size);
		result += sumLUDiag(size);
		result += sumRDDiag(size);
		result += sumRUDiag(size);
		result += 1;
		System.out.println(result);
	}
	
}
