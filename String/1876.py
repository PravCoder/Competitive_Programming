class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        num_good_substr_len_3 = 0

        for i in range(len(s)):
            if i+2 <= len(s)-1:
                substring  = s[i]+s[i+1]+s[i+2]
                # string is already length 3
                if self.num_unique(substring) == 3:
                    num_good_substr_len_3 += 1
                    print(substring)

        return num_good_substr_len_3

    # get number of quniue characters in string
    def num_unique(self, sub):
        uni = []
        for char in sub:
            if char not in uni:
                uni.append(char)
        return len(uni)

# NOTE: for all substrings of length 3, how many are good.
# 1876. Substrings of Size Three with Distinct Characters