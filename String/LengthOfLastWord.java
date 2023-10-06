
class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        String[] words = s.split(" ");


        return words[words.length-1].length();
        
    }
}

// 58. Length of Last Word


// PYTHON SOLUTION
// class Solution:
//     def lengthOfLastWord(self, s: str) -> int:

//         i = len(s)-1 # initalizing a pointer-indx to the end of string
 
//         last_word_length = 0 # stores length of last word

//         while s[i] == " ":  # while the cur-ith element is a space decrement indx-i until we reach teh last letter of the last wowrd
//             i -=1           # or untial we reach a non-empty character

//         while s[i] != " " and i >= 0: # while cur-ith element in string is not empty so while we are iterating throught the characters
//             i-=1                        # of the last word increment the length and decrement the indx-pointer
//             last_word_length += 1

//         return last_word_length
