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