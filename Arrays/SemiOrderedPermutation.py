class Solution:
    def semiOrderedPermutation(self, nums: List[int]) -> int:

        n = len(nums)
        num_operations = 0
       
       # while first element is not one *OR* last-lement is not n
        while nums[0] != 1 or nums[-1] != n:

            if nums[0] != 1:
                indx = nums.index(1) # get index of element-1
                nums[indx], nums[indx-1]= nums[indx-1], nums[indx] # swap element-1 with the element before it
                num_operations += 1
            # if last-element isnt n and check index+1 out of bounds error
            if nums[-1] != n and nums.index(n)+1 <= len(nums)-1:
                indx = nums.index(n) # get index of element-n
                nums[indx], nums[indx+1]= nums[indx+1], nums[indx] # swap element-n with the lement after it
                num_operations += 1
        
        print(nums)
        return num_operations 

# 2717. Semi-Ordered Permutation