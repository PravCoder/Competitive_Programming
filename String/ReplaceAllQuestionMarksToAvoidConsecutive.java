

// TIME LIMIT EXCEEDED
class RepalceAllQuestionMarksToAvoidConsecutive {

    public String modifyString(String s) {

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            // first character is ?
            if (cur == '?' && i == 0) {
                char after = s.charAt(i+1);
                s = getNotEqual(after)+s.substring(1, s.length());
            }
            // last character is ?
            else if (cur == '?' && i == s.length()-1) {
                char before = s.charAt(i-1);
                s = s.substring(0, i) +getNotEqual(before);
            } 
            // between character is ?
            else if (cur == '?' && i > 0 && i < s.length()-1) {
                char before = s.charAt(i-1); 
                char after = s.charAt(i+1);
                s = s.substring(0, i)+ getNotEqual(before, after) +s.substring(i);
            }
        }
        return s;
    }
    // gets character not equal to after
    public char getNotEqual(char after) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i<alpha.length(); i++) {
            if (alpha.charAt(i) != after) {
                return alpha.charAt(i);
            }
        }
        return 'a';
    }
    // gets character not equal to both
    public char getNotEqual(char before, char after) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i<alpha.length(); i++) {
            if (alpha.charAt(i) != after && alpha.charAt(i) != before) {
                return alpha.charAt(i);
            }
        }
        return 'a';
    }
}


// PASSED SOLUTION
class Solution {
    public String modifyString(String s) {
        if (s.equals("?")) {    // edge case
            return "a";
        }

        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '?') {
                // corner case 1
                if (i == 0) {   
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != a[i+1]) {
                            a[i] = c;
                            break;
                        }
                    }
                } 
                // corner case 1
                else if (i == a.length - 1) {   

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != a[i-1]) {
                            a[i] = c;
                            break;
                        }
                    }
                } 
                // regular case
                else {
                    // look for character until its unequal 
                    // with characters at indices i-1 and i+1
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != a[i+1] && c != a[i-1]) {
                            a[i] = c;
                            break;
                        }
                    }
                }
            }
        }

        return new String(a);
    }
}


// 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
