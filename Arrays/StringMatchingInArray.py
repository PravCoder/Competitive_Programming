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

class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:

        output = []
        for i in range(len(words)):
            for j in range(len(words)):
                if i != j and self.isSub(words[i], words[j]) == True and words[i] not in output:
                    output.append(words[i])  # only add first word because it is subtring of another
        return output

    # is substring python "in" check from scratch
    def isSub(self, a, b):  # returns true if a is substring of b
        if len(a) > len(b):
            return False
        # iterate every character in b
        for i in range(len(b)):
            cur_str = ""
            for j in range(len(a)):  # iterate indices os possible substring
                # is start-indx plus substring-indx is valid then add it to cur-str
                if i+j <= len(b)-1:
                    cur_str += b[i+j]
                else:
                    break
            # check if cur-formulated substring is smae as substring
            if cur_str == a:
                return True
        return False