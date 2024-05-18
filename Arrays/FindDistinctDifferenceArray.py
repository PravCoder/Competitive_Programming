class Solution:
    def distinctDifferenceArray(self, nums: List[int]) -> List[int]:

        output = []

        for i in range(len(nums)):
            prefix_distinct = [] 
            for j in range(0, i+1):
                if nums[j] not in prefix_distinct:
                    prefix_distinct.append(nums[j])
            
            suffix_distinct = []
            for k in range(i+1, len(nums)):
                if nums[k] not in suffix_distinct:
                    suffix_distinct.append(nums[k])


            distinct_diff_i = len(prefix_distinct) - len(suffix_distinct)
            output.append(distinct_diff_i)

        return output

# NOTE: for every element in nums they want us to subtract the number of distinct elements before it by the number of distinct elements 
# after it