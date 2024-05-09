class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        # k = number of elements which are not equal to val
        # the first k elements should be the numbers which are not equal to val
        # has to be in-place solution

        # compute k by iterating entire nums
        k = 0
        for n in nums:
            if n != val: k += 1
        
        # for every spot in the beginning of array that is supposed to be reserved for val-not-equal elements
        for i in range(k):
            # if that element is intially equal to val we have to find a element that doesn't equal val to replace its spot
            if nums[i] == val:
                # for every element after cur-i-spot
                for j in range(i+1, len(nums)):
                    # find a element that is not equal to val and replace it with teh cur-i-spot we are looking at
                    if nums[j] != val:
                        nums[i], nums[j] = nums[j], nums[i]

        return k

# NOTE: one side of the array is for elements not equal to val, and other side is val elements.
# [not-val, not-val, not-val, val, val....]