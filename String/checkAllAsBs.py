class Solution:
    def checkString(self, s: str) -> bool:

        for i in range(len(s)):
            if s[i] == "b":
                for j in range(i+1, len(s)):
                    if s[j] == "a":
                        return False

        return True