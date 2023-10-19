import java.util.HashMap;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // {char in pattern : its word mapping in s}
        HashMap<Character, String> bijection = new HashMap<Character, String>();
        // split s-string into array of words
        String[] words = s.split(" ");
        // if there is not enough letters to map to each word in s-string 
        if (pattern.length() != words.length) {
            return false;
        }

        // iterate characters of pattern-string
        for (int i=0; i<pattern.length(); i++) {
            char cur = pattern.charAt(i);  // get current letter
            // if letter doesnt already exist in map add it in map with its value as the word of that idnex in words, {pattern[i] : words[i]}
            if (bijection.keySet().contains(cur) == false) {
                bijection.put(cur, words[i]);
            }
        }
        
        // iterate hasmap and check if and value occurs twice, if it does pattern is not possible because 
        // if multiple letters in pattern map to the same word then it doesn follow the pattern
        for (Character key: bijection.keySet()) {
            System.out.println(key+" = "+bijection.get(key));
            int count = 0;
            for (Character key2: bijection.keySet()) {
                if (bijection.get(key2).equals(bijection.get(key)) == true) {
                    count += 1;
                }
            }
            System.out.println(count);
            if (count > 1) {
                return false;
            }
        }

        // iterate characters of pattern using index i that same index maps to a character in words
        for (int i=0; i<pattern.length(); i++) { 
            String mappedWord = words[i]; // get the character that is paired with pattern[i]-letter
            char cur = pattern.charAt(i); // get character in pattern that is paired with word[i]-word
            // if the mappedWord is NOT equal the hash-mapping of cur-letter of pattern of index i it doesnt follow pattern
            if (mappedWord.equals(bijection.get(cur)) == false) {
                System.out.println(bijection.get(cur)+"!="+mappedWord +",cur="+cur);
                return false;
            }
        }
        return true;
        
    }
}

// 290. Word Pattern
// Patterns: String/Iterable Element Mapping/Pairing, String Iteration, HashMap of Elements in Iterable.