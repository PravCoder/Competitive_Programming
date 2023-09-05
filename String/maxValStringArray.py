class Solution:
    def maximumValue(self, strs) -> int:
        max_val = float("-inf")
        for word in strs:
            if word.isnumeric() == True:
                max_val = max(max_val, int(word))
            else:
                max_val = max(max_val, len(word))

        return max_val
