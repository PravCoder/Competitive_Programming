class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:

        output = []
        for i in range(len(words)):
            for j in range(len(words)):
                if i != j and self.isSub(words[i], words[j]) == True and words[i] not in output:
                    output.append(words[i])  # only add first word because it is subtring of another
        return output

    def isSub(self, a, b):  # returns true if a is substring of b
        if len(a) > len(b):
            return False
        
        if a in b:
            return True

# 1408. String Matching in an Array