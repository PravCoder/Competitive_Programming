# TIME LIMIT EXCEEDED SOLUTION

class ReductionOperationsToMakeArrayElementsEqual:  
    def reductionOperations(self, nums):
        
        operations = 0 # stores number of times we made change to array
        # while all the elements in nums are not equal continue algoritm
        while self.isEqual(nums) == False:
            largest_i = self.getLargest(nums) # get index of largest element in nums
            largest = nums[largest_i]       # get element of largest element in nums

            next_largest_j = self.getNextLargest(nums, largest)     # get index of next largest element in nums
            next_largest = nums[next_largest_j]                     # get next largest element in nums

            nums[largest_i] = next_largest          # do operation, replace largest-element with next largest element
            operations += 1                         # increment operations

        return operations

    def isEqual(self, nums):
        return nums.count(nums[0]) == len(nums) # all elements are equal if the occurances of first element is equal to length

    def getLargest(self, nums): 
        largest = max(nums)     # store max element
        # if max-element only occurs once return its index
        if nums.count(largest) == 1:
            return nums.index(largest)
        # if max-element occurs multiple times, iterate and return its 1st occurance or least-i
        else:
            for i, n in enumerate(nums):
                if n == largest:
                    return i

    def getNextLargest(self, nums, largest): # given nums and current largest-max-element
        removed_largest = [n for n in nums if n != largest] # create new list with only elements not equal to largest
        next_largest = max(removed_largest)     # from that list get the largest element and return its index
        return nums.index(next_largest)


# 1887. Reduction Operations to Make the Array Elements Equal
