class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        // Try all possible substrings
        for (int i = 1; i<s.length(); i++) {
            
            String sub = s.substring(0, i);  // get current sub-string from start to cur-i
            String repeated = "";  // is the repeated string made from cur-cub

            // Repeat the substring to form a potential pattern
            // iterate the number of times sub-stirng can fit in s-string
            for (int j=0; j< s.length()/i; j++) {
                repeated += sub;
            }
            // If the pattern matches the original string, return true
            if (repeated.equals(s)) {
                return true;
            }
            
        }
        // If no repeated substring is found, return false
        return false;
    }
}
// 459. Repeated Substring Pattern


// Patterns: Construct Substring.