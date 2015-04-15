package problem25;

import java.math.BigInteger;

//Answer = 4782

public class Problem25 {

	public static BigInteger fib(BigInteger fn1, BigInteger fn2) {
			return fn2.add(fn1);
	}

	public static void main(String[] args) {
		BigInteger fn1 = new BigInteger("1");
		BigInteger fn2 = new BigInteger("1");
		int i = 3;
		BigInteger fn = fib(fn1, fn2);
		while (fn.toString().length() < 1000) {
			i++;
			fn1 = fn2;
			fn2 = fn;
			fn = fib(fn1, fn2);
		}
		System.out.println(i);
		
	}
}
