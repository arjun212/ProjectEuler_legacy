package problem12;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

//Answer = 76576500

public class Problem12 {

	public static BigInteger nTriangleNumber(int n) {
		BigInteger x = new BigInteger(Integer.toString(n)); 
		BigInteger x1 = new BigInteger(Integer.toString(n + 1)); 
		BigInteger r = (x.multiply(x1)).divide(new BigInteger(Integer.toString(2))); 
		return r; 
	}
	
	public static Set<Integer> getDivisors(BigInteger x) {
		Set<Integer> result = new HashSet<Integer>();
		result.add(1);
		result.add(x.intValue());
		for (int i = 2; i * i < x.intValue(); i++) {
			if ((x.intValue() % i) == 0) {
				result.add(i);
				result.add(x.intValue() / i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int biggestNumDivs = 0;
		int nTriangle = 0;
		while (biggestNumDivs < 500) {
			nTriangle++;
			BigInteger num = nTriangleNumber(nTriangle);
			int numDivs = getDivisors(num).size();
			if (biggestNumDivs < numDivs) {
				biggestNumDivs = numDivs;
			}
		}
		System.out.println(nTriangleNumber(nTriangle));
	}
}
