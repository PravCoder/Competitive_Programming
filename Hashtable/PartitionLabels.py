class PartitionLabels:
    def partitionLabels(self, s):
        
        last_indicies = {} # {letter: last-index}
        for i, letter in enumerate(s):  # iterate input-string
            if letter not in list(last_indicies.keys()):    # if we havent seen this letter, add it
                last_indicies[letter] = i
            # if we have seen this letter and its index is greater than currently last-index, replace it 
            elif letter in list(last_indicies.keys()) and i > last_indicies[letter]: 
                last_indicies[letter] = i

        output = []
        end = 0     # stores index of where the current partition currently ends
        size = 0    # length of currrent section
        for i in range(len(s)): # iterate indicices of s
            cur_letter = s[i]   # get current-letter
            cur_letter_last_index = last_indicies[cur_letter]   # get last-index of current-letter
            # if last-index of cur-letter is beyond our cur-end-index of partion, extend the end of section
            if cur_letter_last_index > end: 
                end = cur_letter_last_index

            size += 1   # each iteration increment size of cur-section

            # if the current-index is equal to the end of cur-section, we finished section
            # because if the largest-last-index in sec
            if i == end: 
                output.append(size)
                size = 0 # reset size of next section, keep end same because its not going to be less

        return output


"""
'many parts at possible' so maximize parts
each unique letter can appear in a single section

763. Partition Labels
"""

