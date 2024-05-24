class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
        
        sums = []

        for i in range(len(nums)):
            if i+1 <= len(nums)-1 and nums[i]+nums[i+1] in sums:
                return True
            elif i+1 <= len(nums)-1 and nums[i]+nums[i+1] not in sums:
                sums.append(nums[i]+nums[i+1] )
        
        return False
