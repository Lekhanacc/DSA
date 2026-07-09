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

// ******************* O (N**2)  *************************

//  class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

//         List<List<Integer>> ans = new ArrayList<>();

//         if (root == null)
//             return ans;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         boolean leftToRight = true;

//         while (!queue.isEmpty()) {

//             int size = queue.size();
//             List<Integer> level = new ArrayList<>();

//             for (int i = 0; i < size; i++) {

//                 TreeNode current = queue.poll();

//                 if (leftToRight)
//                     level.add(current.val);
//                 else
//                     level.add(0, current.val);

//                 if (current.left != null)
//                     queue.offer(current.left);

//                 if (current.right != null)
//                     queue.offer(current.right);
//             }

//             ans.add(level);

//             leftToRight = !leftToRight;
//         }

//         return ans;
//     }
// }

// *************   O(N)   *******************

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            // Fill the list with dummy values
            for (int i = 0; i < size; i++) {
                level.add(0);
            }

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                int index;

                if (leftToRight)
                    index = i;
                else
                    index = size - 1 - i;

                level.set(index, current.val);

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }

            ans.add(level);

            leftToRight = !leftToRight;
        }

        return ans;
    }
}