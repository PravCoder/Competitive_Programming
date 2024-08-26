class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        
        increasing = []
        decreasing = []

        i = 0 # start ith pointer at start until its at end of array
        while i <= len(nums)-1:
            print(f"\ni: {i}")
            sub = [nums[i]]  # cur-sub-array init with cur-i
            j = i # set j to i and while j+1 is greater than the last element in cur-subarray add j+1 to subarray
            while j+1 <= len(nums)-1 and sub[-1] < nums[j+1]:
                print(sub[-1], nums[j+1])
                sub.append(nums[j+1])
                j+= 1 # increment j
            increasing.append(sub)
            i += 1
            
        print(increasing)


        i = 0 # start ith pointer at start until its at end of array
        while i <= len(nums)-1:
            print(f"\ni: {i}")
            sub = [nums[i]]  # cur-sub-array init with cur-i
            j = i # set j to i and while j+1 is greater than the last element in cur-subarray add j+1 to subarray
            while j+1 <= len(nums)-1 and sub[-1] > nums[j+1]:
                print(sub[-1], nums[j+1])
                sub.append(nums[j+1])
                j+= 1 # increment j
            decreasing.append(sub)
            i += 1

        print(decreasing)

        longest = -1

        for sub in increasing:
            longest = max(longest, len(sub))

        for sub in decreasing:
            longest = max(longest, len(sub))

        return longest

# 3105. Longest Strictly Increasing or Strictly Decreasing Subarray