class Solution:
    def shortestToChar(self, s: str, c: str):
        # get all c indicies
        indicies = []
        for i, char in enumerate(s):
            if char == c:
                indicies.append(i)

        
        output = []
        for i in range(len(s)):
            distances = []  # compute distances from all c indiceis to current-char
            for indx in indicies:
                distances.append(abs(i - indx))
            
            output.append(min(distances)) # add the min-dis

        return output