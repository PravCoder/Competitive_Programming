
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        String longestPrefix = "";  // stores longest common prefix
        String possiblePre = "";  // stores current possible prefix
        // iterate characters of first word, because the longest prefix will exist in first word
        for (int i=0; i<strs[0].length(); i++) {
            possiblePre += strs[0].charAt(i);   // add cur-char in first-word to possible-prefix
            boolean common = true;
            
            // iterate words again
            for (String word2: strs) {
                // confirm if all words contains current prefix
                if (isPrefix(possiblePre, word2) == false) {
                    common = false;
                }
            }
            // if cur-prefix is common in all strings and its length is greater update longest-prefix
            if (common &&  possiblePre.length() > longestPrefix.length()) {
                longestPrefix = possiblePre;
            }
            
        }
        return longestPrefix;
    }
    
    // returns true if prefix string is prefix of word-string
    public boolean isPrefix(String prefix, String word) {
        // for the prefix to be prefix in word word needs to longer than prefix
        if (word.length() < prefix.length()) {
            return false;
        }
        // iterate fomr 0 to prefix-length and add word-characters to contructed-string
        String constructedPre = "";
        for (int i=0; i<prefix.length(); i++) {
            constructedPre += word.charAt(i);
        }
        return prefix.equals(constructedPre);
    }
}

// 14. Longest Common Prefix
// Patterns: String Iteration, Prefix Construction