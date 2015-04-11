package problem15;

//Answer = 1.3784652882E11 = 137846528820

public class Problem15 {

	static final int GRIDSIZE = 20;

	static double Grid[][] = new double[GRIDSIZE][GRIDSIZE];

	public static void printGrid() {
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {
				System.out.print(Grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean isTopEdge(CoOrd c) {
		return (c.y == 0);
	}
	
	public static boolean isLeftEdge(CoOrd c) {
		return (c.x == 0);
	}
	
	public static double getTopValue(CoOrd c) {
		if (isTopEdge(c)) {
			return 1;
		} else {
			return Grid[c.x][c.y-1];
		}
	}
	
	public static double getLeftValue(CoOrd c) {
		if (isLeftEdge(c)) {
			return 1;
		} else {
			return Grid[c.x - 1][c.y];
		}
	}
	
	public static void fillGrid() {
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {
				CoOrd c = new CoOrd(i,j);
				Grid[i][j] = getTopValue(c) + getLeftValue(c);
			}
		}
	}
	
	public static void main(String[] args) {
		fillGrid();
		System.out.println(String.valueOf(Grid[GRIDSIZE-1][GRIDSIZE-1]));
	}

}
