class Solution:
    def countVowelSubstrings(self, word: str) -> int:
        vowels = "aeiou"
        count = 0
        for i in range(len(word)):
            sub = "" +word[i]
            for j in range(i+1, len(word)):
                sub += word[j]

                valid = True
                for v in vowels:  # if it contains all 5 vowels
                    if v not in sub:
                        valid = False

                for letter in sub:  # if it has any letters that are not vowels
                    if letter not in vowels:
                        valid = False

                if valid:
                    print(sub)
                    count += 1


        return count