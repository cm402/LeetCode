import java.util.*;
public class InOrderTreeTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * Iterative solution. Iterating down the LHS on the tree, before traversing back
     * to the RHS, using a stack to keep track of the nodes we've seen.
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> seen = new Stack<>();
        TreeNode current = root;
        while(!seen.isEmpty() || current != null){
            
            // traverse down the left nodes of the tree.
            if(current != null){
                seen.add(current);
                current = current.left;
            // once we've found the bottom, grab the value and move
            // onto the right node, repeating the process    
            } else {
                values.add(seen.peek().val);
                current = seen.pop().right;
            }
        }
        return values;
    }

    /*
     * Recursive solution, using a field to store the values.
     * time complexity: O(n)
     * space complexity: O(n)
     * Both of these are worst-case scenarios,
     * where the height of the tree is the same as the no of nodes.
     */
    private List<Integer> values = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        values.clear();
        inorderTraverse(root);
        return values;
    }

    public void inorderTraverse(TreeNode node) {
        if (node == null)
            return;
        if (node.left != null)
            inorderTraverse(node.left);
        values.add(node.val);
        if (node.right != null)
            inorderTraverse(node.right);
    }
}