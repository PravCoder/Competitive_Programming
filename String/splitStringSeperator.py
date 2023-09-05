class Solution:
    def splitWordsBySeparator(self, words, separator: str):

        output = []
        for word in words:
            s = word.split(separator)
            for splited in s:
                if splited != "" and splited != " ": 
                    output.append(splited)

        return output
        