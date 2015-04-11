package problem15;

import java.util.Arrays;

public class Problem15 {

	static final int GRIDSIZE = 2;

	static int Grid[][] = new int[GRIDSIZE][GRIDSIZE];

	public static boolean isDiag(CoOrd c1, CoOrd c2) {
		return (((c1.x == c2.x - 1) && (c1.y == c2.y - 1)) || ((c1.x == c2.x - 1) && (c1.y == c2.y - 1)));
	}

	public static boolean isBottomEdge(CoOrd c) {
		return (c.x == GRIDSIZE);
	}
	
	public static boolean isRightEdge(CoOrd c) {
		return (c.y == GRIDSIZE);
	}
	
	public static int paths(CoOrd c1, CoOrd target) {
		int paths = 0;
		
		if (c1.equals(target))	return 0;
		
		if (isDiag(c1, target))	return 2;
		
		if (isBottomEdge(c1) || isRightEdge(c1))	return 1;
		
		return paths;
	}

	public static void main(String[] args) {

	}

}
