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
    public ListNode swapPairs(ListNode head) {

        // Dummy node helps handle head swap easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // While at least 2 nodes remain
        while (head != null && head.next != null) {

            // Identify the two nodes
            ListNode first = head;
            ListNode second = head.next;

            // Swapping pointers
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move prev and head forward
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
