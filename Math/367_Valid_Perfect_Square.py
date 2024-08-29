
# TIME LIMIT EXCEEDED
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        
        for x in range(0, num+1):
            if x*x == num:
                return True

        return False

# NOTE: given a num the number x that can be squared to equal num will be less than num. So loop through 0 to num and try all possibilties. 