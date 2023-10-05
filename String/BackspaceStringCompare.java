class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {

        String newS = "";
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            // if cur-char is backspace and there is a character to delete
            if (cur == '#' && newS.length() != 0) { // cannot get substring if length is 0
                newS = newS.substring(0, newS.length()-1);
            } else {
                newS += cur;
            }
        }

        String newT = "";
        for (int i=0; i<t.length(); i++) {
            char cur = t.charAt(i);
            if (cur == '#' && newT.length() != 0) {
                newT = newT.substring(0, newT.length()-1);
            // if cur-char is a letter add it to string
            } else {
                newT += cur;
            }
        }

        newS = newS.replaceAll("#", ""); // if there are any # at the beginningof string it wont
        newT = newT.replaceAll("#", ""); // affect resulting string
        System.out.println(newS);
        System.out.println(newT);
        return newS.equals(newT);
        
    }
}

// 844. Backspace String Compare

// Patterns: Substring, Replace Character. 