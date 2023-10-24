
from itertools import permutations

class MinSumFourDigitsSplittingDigits:

    def minimumSum(self, num: int) -> int:
        # get all possible combinations contigous and non-contigosu of string-num
        perms = [''.join(p) for p in permutations(str(num))]
        minSum = 100*100
        # itearte each combinaton
        for string in perms:
            # iterate indicies of string
            for i in range(1, len(string)):
                n1  = int(string[0:i])  # get the left half-pair of cur-i
                n2  = int(string[i:])   # get the right half-pair of cur-i
                # update minsum
                if n1+n2 < minSum:
                    minSum = n1+n2

        return minSum
        
# 2160. Minimum Sum of Four Digit Number After Splitting Digits
# Patterns: Integer Digit Iteration, String Permutations, Minimum
