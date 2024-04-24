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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head, startOfFirst = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        ListNode startOfSecond = middle.next;

        middle.next = null;
        startOfSecond = reverseLinkedList(startOfSecond);

        while(startOfSecond != null){
            ListNode temp1 = startOfFirst.next;
            ListNode temp2 = startOfSecond.next;
            
            startOfFirst.next = startOfSecond;
            startOfSecond.next = temp1;
            startOfFirst = temp1;
            startOfSecond = temp2;
        }
        
    }
    public static ListNode reverseLinkedList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
