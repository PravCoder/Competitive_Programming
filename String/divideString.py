class Solution:
    def divideString(self, s: str, k: int, fill: str):

        while len(s)%k != 0: # make s-string divisible by k
            s += fill

        
        groups = []

        for i in range(0, len(s), k):
            g = ""
            for j in range(i, i+k):
                g += s[j]

            groups.append(g)

        return groups

