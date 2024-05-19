class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        
        inclusive_range = [n for n in range(left, right+1)]

        for n in inclusive_range:
            found = False

            for scope in ranges:
                for i in range(scope[0], scope[1]+1):
                    if n == i:
                        found = True
                        break

            if found == False:
                return False
        
        return True


# 1893. Check if All the Integers in a Range Are Covered