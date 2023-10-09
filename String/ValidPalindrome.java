
class ValidPalindrome {
    public boolean isPalindrome(String s) {

        String original = "";

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isLetterOrDigit(cur) == true) {
                original += Character.toLowerCase(cur);
            }
        }

        String reversed = "";
        for (int i=original.length()-1; i>=0; i--) {
            reversed += original.charAt(i);
        }
        System.out.println(original);
        System.out.println(reversed);
        return original.equals(reversed);
    }
}

// 125. Valid Palindrome


// Patterns: String Iteration Forward/Backward, String Comparison, Removing Characters From String
// by Iterating & Adding to New String. 