package problem9;

//Answer = 31875000

public class Problem9 {

	public static int isPyTriple(int a, int b) {
		//-1 = not PyTriple, else is pyTriple
		double cSquared = (a*a) + (b*b);
		double c = Math.sqrt(cSquared);
		c = Math.round(c);
		if (Math.pow(c, 2) == cSquared) {
			return (int) c;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		for (int a = 1; a < 1000; a++) {
			for (int b = a; b < 1000; b++) {
				int c = isPyTriple(a,b);
				if ((c != -1) && a + b + c == 1000) {
					System.out.println(a*b*c);
					break;
				}
			}
		}
	}
}
