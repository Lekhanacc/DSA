/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // ************** O(N**2) *********
class Solution {

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currentDiameter = leftHeight + rightHeight;

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(currentDiameter,
                Math.max(leftDiameter, rightDiameter));
    }

    private int height(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}