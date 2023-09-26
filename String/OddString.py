class Solution:
    def oddString(self, words) -> str:
        alpha = "abcdefghijklmnopqrstuvwxyz"
        difference = [] # each element stores the difference array for that index word
        for i, word in enumerate(words): # iterate through each word
            arr = []  # temp diff-arr
            for j in range(len(word)): # iterate through each index in word
                if j+1 <= len(word)-1: # if valid index, add the next-letter minus cur-letter to temp-diff-arr
                    arr.append(alpha.index(word[j+1]) - alpha.index(word[j]))
            difference.append(arr) # add the diff-arr of this word in to difference-list
        

        print(difference)
        for arr in difference: # iterate through each difference-arr and find the one that occurs once and 
            if difference.count(arr) == 1: # return its word using its dcorresponding index in differnece-list
                return words[difference.index(arr)]
# 2451. Odd String Difference
