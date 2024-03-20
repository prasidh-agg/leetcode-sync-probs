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
    public ListNode mergeInBetween(ListNode l1, int a, int b, ListNode l2) {

        ListNode newHead = new ListNode(0, l1);
        ListNode nodeToReturn = newHead;
        int count = 0;

        while(count < a){
            newHead = newHead.next;
            count++;
        }
        ListNode cutOffNode = newHead.next;
        newHead.next = l2;

        while(l2.next != null){
            l2 = l2.next;
        }

        while(count < b){
            cutOffNode = cutOffNode.next;
            count++;
        }

        l2.next = cutOffNode.next;
        return nodeToReturn.next;
    }
}
