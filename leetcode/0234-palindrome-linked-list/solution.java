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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode middle = middleNode(head);

        ListNode l1 = head;
        ListNode l2 = reverseList(middle.next);

        while(l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next; l2 = l2.next;
        }
        return true;
    }
    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
