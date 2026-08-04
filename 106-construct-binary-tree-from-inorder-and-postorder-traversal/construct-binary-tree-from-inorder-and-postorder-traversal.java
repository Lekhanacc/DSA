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

    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] inorder,
                           int[] postorder,
                           int inStart,
                           int inEnd,
                           HashMap<Integer, Integer> map) {

        if (inStart > inEnd)
            return null;

        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        int inRoot = map.get(rootValue);

        // Build Right first
        root.right = build(inorder,
                           postorder,
                           inRoot + 1,
                           inEnd,
                           map);

        // Then Left
        root.left = build(inorder,
                          postorder,
                          inStart,
                          inRoot - 1,
                          map);

        return root;
    }
}