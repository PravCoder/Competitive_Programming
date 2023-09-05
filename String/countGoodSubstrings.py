class Solution:
    def countGoodSubstrings(self, s: str) -> int:

        count = 0
        sub_strs = []
        # iterate from 0 to length of list minus substring length + 1 for inclusiion
        for i in range(len(s) - 3 + 1):
            sub = s[i:i + 3]  # Extract the substring
            sub_strs.append(sub)

        print(sub_strs)
        for sub in sub_strs:
            valid = True
            for letter in sub:
                if sub.count(letter)  >1:
                    valid = False
            if valid:
                count += 1

        return count
        