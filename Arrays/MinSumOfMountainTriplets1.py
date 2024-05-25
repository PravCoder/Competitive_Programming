class Solution:
    def minimumSum(self, nums: List[int]) -> int:
        min_sum = 100000000

        for i in range(len(nums)):
            for j in range(len(nums)):
                for k in range(len(nums)):
                    if i < j < k and nums[i] < nums[j] and nums[k] < nums[j] and nums[i]+nums[j]+nums[k] < min_sum:
                        min_sum = nums[i]+nums[j]+nums[k]

        if min_sum == 100000000:
            return -1
        return min_sum

# 2908. Minimum Sum of Mountain Triplets I


class Solution2:
    def minimumSum(self, nums: List[int]) -> int:
        min_sum = 100000000

        # iterate through all possible j-middle elements 2nd elmeent to 2nd to last element
        for j in range(1, len(nums)-1):
            # iterate all elements before cur-middle
            for i in range(0, j):
                # iterate all elements after cur-middle
                for k in range(j+1, len(nums)):
                    # if sum is les than min-sum and elements i<j & k<j
                    if nums[i] + nums[j] + nums[k] < min_sum and nums[i] < nums[j] and nums[k] < nums[j]:
                        min_sum = nums[i] + nums[j] + nums[k]
            


        if min_sum == 100000000:
            return -1

        return min_sum

# NOTE: we cannot always use min(before_j) + nums[j] + min(after_j) because min doesn't
# always guarantee the condition nums[i] < nums[j] and nums[k] < nums[j]. We dont have to 
# check for i < j < k condition beacuse we iterating before and after j. 
        

class Solution3:
    def minimumSum(self, nums: List[int]) -> int:
        min_sum = 100000000

        # iterate through all possible j-middle elements 2nd elmeent to 2nd to last element
        for j in range(1, len(nums)-1):
            min_i = 1000 # stores minimum element before cur-mid
            min_k = 1000 # store minimum element after cur-mid
            # iterate before elements
            for i in range(0, j):
                # check condeition and that it is min
                if nums[i] < nums[j] and nums[i] < min_i:
                    min_i = nums[i]

            for k in range(j+1, len(nums)):
                if nums[k] < nums[j] and nums[k] < min_k:
                    min_k = nums[k]
            # check if a mountain-triplet exists and min-sum
            if min_i != 1000 and min_k != 1000 and min_i + nums[j] + min_k < min_sum:
                min_sum = min_i + nums[j] + min_k


        if min_sum == 100000000:
            return -1

        return min_sum

# NOTE: we cannot always use min(before_j) + nums[j] + min(after_j) because min doesn't
# always guarantee the condition nums[i] < nums[j] and nums[k] < nums[j]. We dont have to 
# check for i < j < k condition beacuse we iterating before and after j. 
