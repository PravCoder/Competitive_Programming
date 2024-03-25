class Solution:
    def threeSum(self, nums):

        output = []
        for i in range(len(nums)):
            for j in range(len(nums)):
                for k in range(len(nums)):
                    triplet = [nums[i], nums[j], nums[k]]
                    triplet_sum = nums[i]+nums[j]+nums[k]
                    triplet.sort()
                    if (i!=j and i!=k and j!=k and triplet_sum == 0 and triplet not in output):
                        output.append(triplet)

        return output