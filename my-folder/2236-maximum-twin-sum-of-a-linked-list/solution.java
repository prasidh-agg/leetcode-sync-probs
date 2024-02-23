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
    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        ListNode slow = head, fast = head, firstList = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middleNext = slow.next;
        slow.next = null;
        //reverse the list from here..
        ListNode secondList = reverseList(middleNext, null);
        while(firstList != null){
            max = Math.max(max, firstList.val + secondList.val);
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return max;
    }
    public ListNode reverseList(ListNode head, ListNode prev){
        if(head == null){
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        return reverseList(next, head);
    }
}


