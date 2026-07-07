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

 // *******    RECURSION    *************

// class Solution {

//     List<Integer> ans = new ArrayList<>();

//     public List<Integer> inorderTraversal(TreeNode root) {

//         inorder(root);

//         return ans;
//     }

//     private void inorder(TreeNode root) {

//         if (root == null)
//             return;

//         inorder(root.left);

//         ans.add(root.val);

//         inorder(root.right);
//     }
// } 

// *********** STACK **************   

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while (root != null || !st.isEmpty()) {

            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            inorder.add(root.val);

            root = root.right;
        }

        return inorder;
    }
}