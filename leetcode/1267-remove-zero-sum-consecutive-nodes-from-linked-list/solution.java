class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        Map<Integer, ListNode> cumulativeSumMap = new HashMap<>();

        int sum = 0;
        ListNode current = dummyHead;

        // First pass: Calculate cumulative sums and save the last occurrence of each sum
        while (current != null) {
            sum += current.val;
            cumulativeSumMap.put(sum, current);
            current = current.next;
        }

        sum = 0;
        current = dummyHead;

        // Second pass: Remove zero-sum sublists
        while (current != null) {
            sum += current.val;
            current.next = cumulativeSumMap.get(sum).next;
            current = current.next;
        }

        return dummyHead.next;
    }
}

