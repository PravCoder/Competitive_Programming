
class OneStringSwapMakeStringEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        
        // if they are already equal we dont need any operations
        if (s1.equals(s2) == true) {
            return true;
        }

        // assuming both string have equal length, iterate their indicies
        for (int i=0; i<s1.length(); i++) {
            char char1 = s2.charAt(i);  // get base-char-i
            // iterate from i to end of strings
            for (int j=i+1; j<s1.length(); j++) {
                char char2 = s2.charAt(j);  // get next-2nd-char to swap with base-char-i

                // swap characters, from 0->i insert-char2 i+1->j insert-char1 j+1->length
                String newS2 = s2.substring(0,i)+char2+s2.substring(i+1, j)+char1+s2.substring(j+1);
                // if newly constructed string equals string-1 reutrn true, esle false
                if (newS2.equals(s1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 1790. Check if One String Swap Can Make Strings Equal
// NOTE: this is assuming that s2 is the string that is messed up, we are not checking if we can
// make a swap operation in s1 to equal s2. "at most one string swap on exactly one of the strings"
// Patterns: Nested Loop, SubString Construction Using Built-In Method, Replacing Characters