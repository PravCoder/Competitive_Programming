# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:

        cur = head  # init cur-pointer to head-node
        # while the cur-node-pointer is not None
        while cur != None:
            # inner loop: while the cur-node.next is not None so it is not the tail-last-node
            # and the cur-node value is equal to the next node value set the cur-node-next
            # to the node after its next, skipping that duplicate node
            # since list is sorted duplicate ele,ents are djacent and we keep skipping them
            # until we find a node is not equal to cur, cur.val != cur.next.val, then we shift the 
            # cur-node-pointer to its next-node
            while cur.next != None and cur.val == cur.next.val:
                cur.next = cur.next.next

            # we set cur-node-pointer to the node after that, which is a different node
            cur = cur.next

        return head


# NOTE: duplicates come right after its first occurance. Tail.next is None. Outer loop controls the cur-node-pointer
# inner loop controls the duplicates