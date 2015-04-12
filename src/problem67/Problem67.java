package problem67;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//Answer = 7273

public class Problem67 {

	static final String dataFile = "./src/problem67/data";

	static TreeNode root;

	static ArrayList<TreeNode> leafNodes = new ArrayList<TreeNode>();

	public static int getRowSize(int row) {
		int acc = 0;
		for (int i = 1; i <= row; i++) {
			acc += i;
		}
		return acc;
	}

	public static void importData() throws IOException {
		File file = new File(dataFile);
		Scanner sc = new Scanner(file);
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();

		while (sc.hasNextInt()) {
			TreeNode x = new TreeNode(null, null, sc.nextInt());
			nodes.add(x);
		}

		for (int i = 0; i < nodes.size(); i++) {
		}

		int row = 1;
		int rowSize = getRowSize(row);
		int i = 0; // Nodes we've looked at so far
		for (TreeNode t : nodes) {
			if (i + row < nodes.size()) {
				t.lChild = nodes.get(i + row);
				t.rChild = nodes.get(i + row + 1);
				t.lChild.rParent = t;
				t.rChild.lParent = t;
				i++;
				if (i == rowSize) {
					row++;
					rowSize = getRowSize(row);
				}
			} else {
				leafNodes.add(t);
			}
		}

		root = nodes.get(0);
		sc.close();
	}

	public static void updatePathCosts() {
		LinkedList<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(root);
		while (!qu.isEmpty()) {
			TreeNode head = qu.remove();
			head.pathCost += head.maxParent();
			if ((head.lChild != null) && (!qu.contains(head.lChild))) {
				qu.add(head.lChild);
			}
			if ((head.rChild != null) && (!qu.contains(head.rChild))) {
				qu.add(head.rChild);

			}
		}
	}

	public static int getBiggestPathCost() {
		int biggestPathCost = 0;
		for (TreeNode t : leafNodes) {
			if (biggestPathCost < t.pathCost) {
				biggestPathCost = t.pathCost;
			}
		}
		return biggestPathCost;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		importData();
		updatePathCosts();
		System.out.println(getBiggestPathCost());

	}

}
