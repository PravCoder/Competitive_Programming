# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        # compute rounded middle index of arr, the first one is root of tree
        mid = len(nums)//2  
        # if middle-indx is out of range return None
        if mid < 0 or mid >= len(nums):
            return None

        # cur-root for subtree create obj, its value is the mid-indx vlaue in given nums-arr
        root = TreeNode(nums[mid])
        # cur-root.left equal to recursive call passing in left-side of array not including mid-indx
        root.left = self.sortedArrayToBST(nums[0:mid])
        # cur-root.right equal to recursive call passing in right-side of array not including mid-indx
        root.right = self.sortedArrayToBST(nums[mid+1:len(nums)])
        # we can do this because the array is sorted so left-side is less elements than mid, right-side is right 
        # elements  

        # at the end returns the root
        return root

# NOTE: in binary search tree the left sub tree nodes are less, right sub tree nodes are greater than root of that subtree. After the root the left and right of the root is set as the new root. Continously splitting the array. 
# 