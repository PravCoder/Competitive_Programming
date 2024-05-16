class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        missing = [] 
        n = len(nums)

        for i in range(1, n+1):
            print(i)
            if i not in nums:
                missing.append(i)

        return missing