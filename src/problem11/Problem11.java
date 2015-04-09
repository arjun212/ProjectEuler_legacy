package problem11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Answer = 70600674

public class Problem11 {
	/*
	 * Directions denoted by value around cell X 1|2|3 4|X|5 6|7|8
	 */
	static int data[][] = new int[20][20];

	public static void importData() throws IOException {
		File file = new File("./src/problem11/data");
		Scanner sc = new Scanner(file);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}

	public static int prodInDirection(CoOrd cell, int D) {
		// 4 Adjacent Cells in Direction D
		CoOrd adjCells[] = new CoOrd[4];
		switch (D) {
		case 1:
			for (int i = 0; i < 4; i++) {
				adjCells[i] = new CoOrd(cell.x - i, cell.y - i);
			}
			break;
		case 2:
			for (int i = 0; i < 4; i++) {
				adjCells[i] = new CoOrd(cell.x, cell.y - i);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				adjCells[i] = new CoOrd(cell.x + i, cell.y - i);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				adjCells[i] = new CoOrd(cell.x - i, cell.y);
			}
			break;
		case 5:
			for (int i = 0; i < 4; i++) {
				adjCells[i] = new CoOrd(cell.x + i, cell.y);
			}
			break;
		case 6:
			for (int i = 0; i < 4; i++) {
				adjCells[i] = new CoOrd(cell.x - i, cell.y + i);
			}
			break;
		case 7:
			for (int i = 0; i < 4; i++) {
				adjCells[i] = new CoOrd(cell.x, cell.y + i);
			}
			break;
		case 8:
			for (int i = 0; i < 4; i++) {
				adjCells[i] = new CoOrd(cell.x + i, cell.y + i);
			}
			break;
		}
		int acc = 1;
		for (int i = 0; i < 4; i++) {
			if (outOfBounds(adjCells[i])) {
				return -1;
			} else {
				acc *= data[adjCells[i].x][adjCells[i].y];
			}
		}
		return acc;

	}

	private static boolean outOfBounds(CoOrd coOrd) {
		return !(coOrd.x >= 0 && coOrd.y >= 0 && coOrd.x < 20 && coOrd.y < 20);
	}

	public static void main(String[] args) throws IOException {
		importData();
		int biggest = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				for (int k = 1; k < 9; k++) {
					int x = prodInDirection(new CoOrd(i, j), k);
					if (biggest < x) {
						biggest = x;
					}
				}
			}
		}
		System.out.println(biggest);
	}
}
