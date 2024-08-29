
# TIME LIMIT EXCEEDED
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        
        for x in range(0, num+1):
            if x*x == num:
                return True

        return False

# NOTE: given a num the number x that can be squared to equal num will be less than num. So loop through 0 to num and try all possibilties. 


# PASSED SOLUTION
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        
        left = 1    # init left-pointer to 1
        right = num # start right-pointer to num or target
        # keep looping until our pointers have crossed
        while left <= right:
            mid = (left+right) // 2 # compute the midpoint of the left/right pointers
            square = mid * mid      # compute the square of the midpoint
            # if the square-midpoint is more than target, then we need to narrow our search range
            # and we need to make square less so we set right-pointer to just before mid, which makes
            # sure that we are looking for lesser numbers to compute the square to get closer to target
            if square > num:        
                right = mid-1
            # if the square-midpoint is less than target, then we need to narrow our search range
            # and we need to make square more so we set left-pointer to just after mid, which makes
            # sure that we are looking for greater numbers to compute the square to get closer to target
            elif square < num:
                left = mid+1
            # if thes square is targe we found solution
            elif square == num:
                return True

        return False

# NOTE: given a num, the number-x that can be squared to equal num will be in the range [1, num]. So looping through this range and trying all possibilties is too slow. So we use binary search to search this range for our target. 
# remeber binary search only works for sorted and our range is already sorted. And we do not need to check for integers because the mid computation rounds. 

# TAGS: binary search, math