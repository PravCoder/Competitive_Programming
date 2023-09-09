class Solution:
    def commonChars(self, words):


        output = []
        word1 = set(words[0])

        # iterate characters of first word
        for letter in word1:
            # stores the number of occurances of current letter in each word
            counts = [] 
            # iterate each word once again
            for word in words:
                # add the number of occurances to counts array
                counts.append(word.count(letter))
            # we can only add the current letter to the minium number of times it occurs in each
            # word. If it occurs zero times in a word we iterate zero times and do not add it
            for _ in range(min(counts)):
                output.append(letter)

        return output

# NOTE: the problem is  duplicates should be included so we cant just iterate each word and each letter 
# and validate that it exists in every word and add it to output. Because that adds every 
# singular letter that exists in all words to ouptut. Instead if 'a' exists in all words once
# we add 'a' to output once. If 'b' exist at least 2 times in each word then we add 'b' be twice. 