class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        count = 0
        # iterate every word and see if its rpefix & suffix
        for i in range(len(words)):
            for j in range(i+1, len(words)):
                # print(f"{words[i]},{words[j]}: {self.isPrefixAndSuffix(words[i], words[j])}")
                if self.isPrefixAndSuffix(words[i], words[j]):
                    count += 1

        return count
        # a = "a"
        # b = "abb"
        # print(f"{a},{b}: {self.isPrefixAndSuffix(a, b)}")
        # return -1

    def isPrefixAndSuffix(self, str1, str2):
        print("Aaa")
        # if str1 is longer than str2 then it is impossible for it ot be a prefix/suffix
        if len(str1) > len(str2):
            return False
        # check prefix iterate str1 and check respective character, if not equal prefix not possible
        for i in range(len(str1)):
            if str1[i] != str2[i]:
                return False
        # check suffix
        j = len(str1)-1 # indx for str1
        indx = len(str2)-1 # indx for str2, both starting at their last indexs
        while j != -1 and indx != -1: # while both of these are not -1, os inclduing 0th index
            print(j, indx)
            print(str1[j],str2[indx] )
            # if respective characeters are not equal suffix is not possibel
            if str1[j] != str2[indx]:
                return False
            # decrement both indicies so going down, from back to front
            indx -= 1
            j -= 1
        # after all checks then suffix/prefix is possbile
        return True
            
# 3042. Count Prefix and Suffix Pairs I