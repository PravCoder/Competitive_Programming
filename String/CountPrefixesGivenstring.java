public class CountPrefixesGivenstring {

    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (int i=0; i<words.length; i++) {
            String curWord = words[i];
            String curPrefix = "";  // s-prefix relative to length of curWord
            
            if (curWord.length() <= s.length()) {
                for (int j=0; j<curWord.length(); j++) {
                    curPrefix += s.charAt(j);
                }
            }
            
            System.out.println("C: " + curPrefix + " P: " + s);
            
            // if prefix of s relative to lenght of curWord is equal to the curWord it self
            // then curWord is a prefix of s
            if (curPrefix.equals(curWord)) {
                count += 1;
            }
        }

        return count;
        
    }
    
}
