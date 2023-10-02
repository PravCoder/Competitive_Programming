class CheckStringPrefixArray {
    public boolean isPrefixString(String s, String[] words) {
        // s=prefix
        String total = "";
        for (String w: words) {
            total += w; // keeps adding the word-string total total-string
            // if at any point the current-prefix-total-string equals s-prefix-string, return true
            if (total.equals(s)) {
                return true;
            // if total-prefix-string is greater than prefix-string and we havent found equalvent prefix
            // then prefix in words-concatenation is not possible. 
            } else if (total.length() > s.length()) {
                return false;
            }
        }
        return false;
    }
}

// 1961. Check If String Is a Prefix of Array