class Solutio1:
    def groupAnagrams(self, strs):
        # {sorted_word: [group]}
        # each key is a unique sorted_word
        hash_map = {}


        sorted_strs = []   # stores strings in strs but sorted
        for word in strs:  
            sorted_strs.append("".join(sorted(word)))    # add sorted-str into list

        # iterate sorted strings
        for word in sorted_strs:
            if word not in hash_map.keys(): # if it doesnt exist in map, add it with empty list value
                hash_map[word] = []

        # iterate orginal strings in strs
        for word in strs:
            sorted_str = "".join(sorted(word))  # sort cur-string
            for key in hash_map.keys(): # iterate each key in map, each unqiue sorted word
                if sorted_str == key:  # if cur-string-sorted in equal to unique-sorted-word-key
                    hash_map[key].append(word)  # add orginal cur-word to the unique-sorted-word-key's values list

        output = [] # each element is a list group of anagrams
        for key in hash_map.keys():   # iterate unique-sorted-keys and get each group of anagrams as list
            output.append(hash_map[key])    # and add it to output-array
        return output
    

class Solution2:
    def groupAnagrams(self, strs):

        storage = {} # {unqiue: indx}
        output = [] # [[group1], [group2], ....]

        # iterate each string in strs
        for s in strs:
            sorted_s =  "".join(sorted(s))  # sort current-string 
            # if sorted-cur-string is not is storage-hash-map
            if sorted_s not in storage.keys(): 
                output.append([])   # add an empty list for output-array for it
                # add sorted-string to map, set index of group to be current last index of output-list
                storage[sorted_s] = len(output)-1  
            # if sorted-strin exists in storage then we can add it to its gorup
            if sorted_s in storage:
                indx = storage[sorted_s] # get index of group using sorted-string
                output[indx].append(s)  # add orignal-current-unsorted-string to the indx of sorted-string in output-list

        return output
