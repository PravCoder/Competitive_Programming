class Solution:
    def minimumCost(self, nums: List[int]) -> int:

        min_sum = 100000
        # represents...
        # end of first subarr, need to end 2 before last-element because we have to leave elements second/third subarr
        for i in range(0, len(nums)-2):
            # end of second subarr, need to end 1 before last-element because we have to leave an element for third subarr
            for j in range(i+1, len(nums)-1):
                # end of third subarr, it can go up to last element
                for k in range(j+1, len(nums)):
                    first = nums[0:i+1] # from first-element to ith
                    second = nums[i+1:j+1] # from after ith to before jth
                    third = nums[j+1:k+1] # from after jth to kth
                    cur_sum = first[0]+second[0]+third[0]
                    if cur_sum < min_sum:
                        min_sum = cur_sum

        return min_sum




# 3010. Divide an Array Into Subarrays With Minimum Cost I