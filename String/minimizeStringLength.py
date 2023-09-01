class Solution:
    def minimizedStringLength(self, s: str) -> int:
        # covert s-string into array
        s_list = [char for char in s]
        temp = s_list.copy() # copy s-array for deletion
        # iterate indices of s_list
        for i in range(len(s_list)):
            letter = s_list[i]      # get current char in s_list
            # if char exists more than once currently in string, remove it
            if temp.count(letter) > 1:
                temp.remove(letter)

        print("".join(temp))
        return len(temp)  # return length of string after deleting
