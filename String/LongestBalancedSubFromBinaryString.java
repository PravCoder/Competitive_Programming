
class LongestBalancedSubFromBinaryString {
    public int findTheLongestBalancedSubstring(String s) {

        String longest = ""; // stores longest balanced substring
        // iterate characters os s-string
        for (int i=0; i<s.length(); i++) {
            String sub = ""+s.charAt(i);  // initlize current sub-string to base-i-char
            // if sub-string has equal # of ones/zeros and all zeros are before all ones
            // and sub-string lenght is more than cur-longest-subs-string length
            if (checkOnesZeros(sub) && isSplit(sub) && sub.length() > longest.length()) {
                    longest = sub;
            }
            // iterate from base-i-char to end of s-string
            for (int j=i+1; j<s.length(); j++) {
                sub += s.charAt(j); // add next-char to sub-string
                // if sub-string has equal # of ones/zeros and all zeros are before all ones
                // and sub-string lenght is more than cur-longest-subs-string length
                if (checkOnesZeros(sub) && isSplit(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        
        return longest.length();
        
    }

    public boolean isSplit(String s) {
        // get first/last indicies of zeros/ones
        int zeroFirst = s.indexOf('0');
        int zeroLast = s.lastIndexOf("0");
        int oneFirst = s.indexOf('1');
        int oneLast = s.lastIndexOf("1");

        // iterate from first occurance of zero to last occurance of zero and if 1 exists in that 
        // range it is not split
        for (int i=zeroFirst; i<zeroLast; i++) {
            if (s.charAt(i) =='1') {
                return false;
            }
        }
        // iterate from first occurance of one to last occurance of one and if 0 exists in that 
        // range it is not split
        for (int i=oneFirst; i<oneLast; i++) {
            if (s.charAt(i) =='0') {
                return false;
            }
        }
        // if its split but all the ones come before all the zeros
        if (oneFirst < zeroFirst) {
            return false;
        }

        return true;
    }

    // return true if # of ones/zeros are equal
    public boolean checkOnesZeros(String s) {
        int ones = 0;
        int zeros = 0;
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '0') {
                zeros += 1;
            }
            else if (cur == '1') {
                ones += 1;
            }
        }
        return ones == zeros;
    }
}

// 2609. Find the Longest Balanced Substring of a Binary String


// Patterns: String Iteration, Occurances of Character, Substring Construction, Nested Loop.