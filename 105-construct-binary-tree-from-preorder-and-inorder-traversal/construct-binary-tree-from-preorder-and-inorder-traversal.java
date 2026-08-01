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
class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store value -> index of inorder
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        // Base Case
        if (preStart > preEnd || inStart > inEnd)
            return null;

        // Root is first element of preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find root index in inorder
        int inRoot = map.get(root.val);

        // Number of nodes in left subtree
        int leftSize = inRoot - inStart;

        // Build left subtree
        root.left = build(preorder,
                          preStart + 1,
                          preStart + leftSize,
                          inorder,
                          inStart,
                          inRoot - 1);

        // Build right subtree
        root.right = build(preorder,
                           preStart + leftSize + 1,
                           preEnd,
                           inorder,
                           inRoot + 1,
                           inEnd);

        return root;
    }
}