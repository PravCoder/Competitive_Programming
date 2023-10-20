class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        
        count = 0 # number of times word repeats

        while True:
            # if word& cur-count is not in seunce reutrn minus which is the previous count 
            # or number of strings that existed in sequence
            if word*count not in sequence:
                return count-1

            # if its in seqnece increment it. 
            count += 1
        
        return count

# NOTE: python stirng * int returns that string reeating int times
# 1668. Maximum Repeating Substring
