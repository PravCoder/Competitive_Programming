import java.util.ArrayList;

class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        
        // stores reversed letters in s-string
        ArrayList<Character> letters = new ArrayList<Character>();

        // iterate characters of s-string
        for (int i=0; i<s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) == true) {
                letters.add(0, s.charAt(i)); // add each character to start of list to reverse
            }
        }
        // iterate s-string
        for (int i=0; i<s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) == true) {
                // add new-character in current position, which is first element in list
                s = s.substring(0,i)+letters.get(0)+s.substring(i+1, s.length());
                letters.remove(0); // remove first element in list
            }
        }
        return s;


    }
}
// 917. Reverse Only Letters
