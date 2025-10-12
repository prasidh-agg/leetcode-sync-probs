# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]: 
        if head is None:
            return None

        p1 = p2 = head
        # send the second pointer n steps ahead
        while n > 0:
            p2 = p2.next
            n -= 1
        if p2 is None:
            return head.next
        
        # now move both pointers together until the second (delayed) one reaches the end
        while(p2 and p2.next != None):
            p1 = p1.next
            p2 = p2.next
        
        # this would ensure that our p1 pointer reaches one node before the node to be removed (nth from the end)
        p1.next = p1.next.next
        return head
