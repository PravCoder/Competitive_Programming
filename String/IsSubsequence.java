
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // if target-substring-length is more than t-string length then not possible
        if (s.length() > t.length()) {
            return false;
        }
        // if target-sub-length is zero then it is always substring of t-string
        if (s.length() == 0) {
            return true;
        }

        int sIndx = 0;  // stores index of substring we are looking for
        String sub = "";  // the current substring we have frmo t-string
        // iterate character t-string
        for (int i=0; i<t.length(); i++) {
            char cur = t.charAt(i);  // get current character in t-string
            // if cur-character is equal to the character in s-sub-string we are looking for
            if (cur == s.charAt(sIndx)) {
                sub += cur;  // add it to substring
                sIndx += 1;  // increment indx to look at next character in s-substring
            } 
            // after each iteartion check if constructed sub-string is equal to target
            // to prevent index out of bounds error because we are incrementing the index
            if (sub.equals(s) == true) {
                return true;
            }

        }
        // after attempting to construct s-substring from t-string
        // check if the substring made from t-string is equal to s-target-subs-string
        return sub.equals(s);
        
    }
}

// Patterns: One Pointer Method, Substring Construction. 

// 392. Is Subsequence
