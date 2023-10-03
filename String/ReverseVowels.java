import java.util.ArrayList;

class ReverseVowels {
    public String reverseVowels(String s) {
        // stores all of the letters in s-string
        ArrayList<Character> characters = new ArrayList<Character>();
        // stores all fo the vowel-occurances in s-string in reverse order
        ArrayList<Character> vowels = new ArrayList<Character>();
        String vowelsKey = "aeiouAEIOU";  // all vowels case-sensitive

        // iterate characters of s-string
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);  // get current letter
            characters.add(cur);  // add it to all characters
            // if letter is vowel then add it to beginning of list to reverse vowels
            if (vowelsKey.contains(String.valueOf(cur)) == true) {
                vowels.add(0, cur);
            }
        }
        
        int vIndx = 0;  // stores index in vowels of the current vowel we are going to add, 0-index means the last
        // vowel in original-string
        // iterate characters of s-string
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);  // get current-char
            // if current letter is a vowel
            if (vowelsKey.contains(String.valueOf(cur)) == true) {
                // vowels.get(vIndx)-> gets the vowel we are going to replace char-i with in s-string
                s = s.substring(0, i)+ vowels.get(vIndx)+ s.substring(i+1, s.length());
                // for redundancy add the reversed-vowl in place of the character-i in s-string-arr-characters
                characters.set(i, vowels.get(vIndx));
                vIndx += 1;  // increment vowel-index only when we encounter a vowle in s-string
            }
        }
        return s;
    }
}

// 345. Reverse Vowels of a String
