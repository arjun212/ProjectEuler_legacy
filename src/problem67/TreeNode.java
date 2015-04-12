package problem67;

public class TreeNode {
	public TreeNode lParent;
	public TreeNode rParent;
	public TreeNode lChild;
	public TreeNode rChild;
	public int value;
	public int pathCost;
	

	public TreeNode(TreeNode left, TreeNode right, int val) {
		this.lParent = left;
		this.rParent = right;
		if (lParent != null) this.lParent.rChild = this;
		if (rParent != null) this.rParent.lChild = this;
		this.value = val;
		this.pathCost = val;
	}

	public int maxParent() {
		if ((lParent == null) && (rParent == null)) {
			return 0;
		} else if (lParent == null) {
			return rParent.pathCost;
		} else if (rParent == null) {
			return lParent.pathCost;
		} else {
			return Math.max(lParent.pathCost, rParent.pathCost);
		}
	}

}
