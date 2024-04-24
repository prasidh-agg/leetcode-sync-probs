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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;

        ListNode begin = head;
        while(head.next != null){
            ListNode temp = head.next;
            int val1 = head.val;
            int val2 = temp.val;
            ListNode newNode = new ListNode(calcGcd(val1, val2));
            head.next = newNode;
            newNode.next = temp;
            head = temp;
        }
    return begin;
    }
    private static int calcGcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return calcGcd(b, a % b);
    }
}
