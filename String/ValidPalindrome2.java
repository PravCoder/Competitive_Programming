class ValidPalindrome2 {
    public boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length()-1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i += 1;
                j -= 1;
            }
            // context: we know everything before-i and everything after-j is a palindrome so far
            // if the character is not: check if the substring between i+1 and j skipping i is palindrome 
            // check if the substring between i and j-1 skipping j is palindrome. 
            // so if skipping i or j creates a valid palindrome then reutrn true
            else if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String a, int i, int j) {
        // int i = 0;
        // int j = a.length()-1;
        while (i <= j) {
            if (a.charAt(i) != a.charAt(j)) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
}

// NOTE: 2-pointer approach for detemrining if stirng is palindrome is 
// one pointer si at start and 2nd pointer is at end and keep moving 
// pointers toward each other until they are nto equal at their position then its not palindrome

// Patterns: Two Pointer String, Palindrome, 

// 680. Valid Palindrome II
