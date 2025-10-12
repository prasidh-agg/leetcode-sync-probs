# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # keep a copy of the list1
        l1 = head

        # find middle of the list so that we can reverse the second half of the list
        # 1-2-3-4 mid at 2
        # 1-2-3-4-5 mid at 3
        mid = self.middleNode(head)

        # reverse the second half of the list
        # 4-3
        # 5-4-3
        l2 = self.reverseList(mid.next)

        # cut the connection between the the middle node and it's next
        # 1-2-null 4-3-null
        # 1-2-3-null 5-4-null
        mid.next = None
        
        # before we start manipulating l1, keep it in head so that we can return the res list from here
        while(l2):
            temp1, temp2 = l1.next, l2.next

            l1.next, l2.next = l2, temp1

            l1, l2 = temp1, temp2

    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        # while we have not processed the last node and gone to null
        while(head != None):
            # save the next node before we manipulate the head
            next_node = head.next

            # remove the forward connection by assigning head's next to the previous node
            head.next = prev

            # make sure the previous node for the next iteration is moved forward to the current head
            prev = head

            # move the current head to the next node that we saved for next iteration
            head = next_node
        return prev
        
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while(fast.next and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        return slow
