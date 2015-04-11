package problem14;

//Answer = 837799
//Slow Execution Time
public class Problem14 {

	final static int MAXINDEX = 1000000;
	
	static int chainSize[] = new int[MAXINDEX + 1];

	
	public static double nextNum(double x) {
		if ((x % 2) == 0) {
			return x / 2;
		} else {
			return (3 * x) + 1;
		}
	}

	public static int getEmptyIndex() {
		int i = 2;
		while (i <= MAXINDEX) {
			if (chainSize[i] != 0) {
				i++;
			} else {
				return i;
			}
		}
		return 1;
	}

	public static int logTwo(double x) {
		double result = Math.log(x) / Math.log(2);
		if (result == Math.floor(result)) {
			return (int) result;
		} else {
			return -1;
		}
	}
	
	public static int seqLen(int x) throws InterruptedException {
		int count = 1;
		double nextNum = 0;
		double internalX = x;
		boolean oneReached = false;
		while (!oneReached) {
			nextNum = nextNum(internalX);
			if (logTwo(nextNum) != -1) {
				if (nextNum <= MAXINDEX) {
					chainSize[(int) nextNum] = logTwo(nextNum);
				}
				return count + logTwo(nextNum);
			} else if ((nextNum != 1) && (nextNum <= MAXINDEX)
					&& (chainSize[(int)nextNum] == 0)) {
				count++;
				internalX = (int) nextNum;
			} else if (nextNum > MAXINDEX) {
				count++;
				internalX = nextNum;
			} else {
				count = count + chainSize[(int)nextNum];
				oneReached = true;
			}
		}
		return count;
	}

	public static void main(String[] args) throws InterruptedException {
		int index;
		double prevPercent = 0;
		System.out.println(prevPercent + "%");
		while ((index = getEmptyIndex()) != 1) {
			double currentPercent = Math.round((index/(double)MAXINDEX)*100);
			if (currentPercent != prevPercent) {
				prevPercent = currentPercent;
				System.out.println(currentPercent + "%");
			}
			System.out.flush();
			chainSize[index] = seqLen(index);
		}
		int biggestChain = 0;
		int biggestIndex = 0;
		for (int i = 2; i <= MAXINDEX; i++) {
			if (biggestChain < chainSize[i]) {
				biggestIndex = i;
				biggestChain = chainSize[i];
			}
		}
		System.out.println(biggestIndex);
	}

}
