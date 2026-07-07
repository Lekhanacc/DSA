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
 
//  ************    RECURSION   ******************
// class Solution {

//     List<Integer> ans = new ArrayList<>();

//     public List<Integer> postorderTraversal(TreeNode root) {

//         postorder(root);

//         return ans;
//     }

//     private void postorder(TreeNode root) {

//         if (root == null)
//             return;

//         postorder(root.left);

//         postorder(root.right);

//         ans.add(root.val);
//     }
// }

//   ***************    1 STACKS    ************************

import java.util.*;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !stack.isEmpty()) {

            if (curr != null) {

                stack.push(curr);
                curr = curr.left;

            } else {

                TreeNode node = stack.peek();

                if (node.right != null && lastVisited != node.right) {

                    curr = node.right;

                } else {

                    ans.add(node.val);
                    lastVisited = stack.pop();

                }
            }
        }

        return ans;
    }
}
 
