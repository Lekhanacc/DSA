/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: find length
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: optimize k
        k = k % length;
        if (k == 0) return head;

        // Step 3: make circular
        curr.next = head;

        // Step 4: move to new tail
        int steps = length - k;
        ListNode newTail = head;
        while (steps-- > 1) {
            newTail = newTail.next;
        }

        // Step 5: break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}