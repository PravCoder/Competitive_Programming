from itertools import product

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        output = []

        # each digit-number maps to some letters
        digitMap = {"2": "abc","3":"def","4":"ghi", "5":"jkl","6":"mno","7":"qprs","8":"tuv","9":"wxyz"}

        # given what digit we are looking at i, and the curStr that we have built so far
        def backtrack(i, curStr):
            # if the length of curStr that we are buliding is equal to the length of the digits then we are done building this combination
            if len(curStr) == len(digits):
                output.append(curStr)       # and add this combination to the output
                return

            # for every letter that the cur-digit-i maps to and increment i+1 because we are adding a letter, add that letter to the curStr we are building
            for letter in digitMap[digits[i]]:
                backtrack(i+1, curStr + letter)
    
        return output
            
# NOTES: for every digit in digits-string it can any of the 3 of the letters that it maps to. 



