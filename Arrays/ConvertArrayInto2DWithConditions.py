class COnvertArrayInto2DWithConditions:
    def findMatrix(self, nums):

        output = [[]]  # init output to empty 2D list

        # while length of nums is zeor
        while len(nums) > 0:
            # keep iterating nums
            for i, n in enumerate(nums):
                need_row = self.needNewRow(output, nums) # do we need a new row?
                # if we need a new row
                if need_row == True:
                    output.append([])   # add new row to end of 2Dlist
                    output[-1].append(n)    # add the current element to the end row
                    nums.pop(i)             # remove n-th element from nums because it was assigned a row
                # if we do not need a new row
                elif need_row == False:
                    # iterate nums again to find the element we can add to the end of output
                    for j, n2 in enumerate(nums):
                        if n2 not in output[-1]: # if the element is not in output[-1] we can add it 
                            output[-1].append(n2)   # and remove it from nums
                            nums.pop(j)

        return output

    # given current state of output and current state of nums we havent looked at
    # returns false if there exists an element in nums that we can add to the end of output without 
    # having duplicates in the end of the output, returns true otherwise
    def needNewRow(self, output, nums):
        for i, n in enumerate(nums):
            if n not in output[-1]:
                return False

        return True
"""
manaully execute the algorithm
[1,3,4,1,2,3,1]
[[]]
        
"""
        
# 2610. Convert an Array Into a 2D Array With Conditions
# Patterns: Iterate While Array is Not Empty, 2D-Array,Array Conversion. 
            
        