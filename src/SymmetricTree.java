import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {
    /*
     * Recursive solution. 
     */
    public boolean isSymmetricRecursive(TreeNode root) {
        return isSame(root.left, root.right);
    }
    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSame(left.left, right.right) && isSame(right.left, left.right);
    }

    /*
     * Iterative solution (work in progress)
     */
    public static boolean isSymmetric(TreeNode root) {
        // to check if a tree is symmetric, could use some form of
        // traversal, inverted for the RHS, comparing both left/right
        // values until we find one that doesn't match, otherwise return true.
        // in-order traversal I've used before, so could try that.
        // we keep going left until we reach the bottom, then up retreat up and
        // go right, using a stack to keep track of visited nodes.
        if(root == null)
            return true;
        Stack<TreeNode> visitedLeft = new Stack<>();
        Stack<TreeNode> visitedRight = new Stack<>();
        TreeNode currentLeft = root.left;
        TreeNode currentRight = root.right;
        while(!visitedLeft.isEmpty() || !visitedRight.isEmpty()
         || currentLeft != null || currentRight != null){
            if (currentLeft == null || currentRight == null)
                return currentLeft == currentRight;
            if(currentLeft.val != currentRight.val)
                return false;
            if(currentLeft != null){
                visitedLeft.push(currentLeft);
                currentLeft = currentLeft.left;
            } else {
                currentLeft = visitedLeft.pop().right;
            }
            if(currentRight != null){
                visitedRight.push(currentRight);
                currentRight = currentRight.right;
            } else {
                currentRight = visitedRight.pop().left;
            }
        }
        return true;
    }

    /*
     *  Example non-symetric tree
     *          1
     *         / \
     *        2   2
     *         \   \
     *          3   3
     */
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(SymmetricTree.isSymmetric(root)); // false
    }
}