import java.util.ArrayList;

class Keyboard {
    public String[] findWords(String[] words) {
        
        ArrayList<String> validWords = new ArrayList<String>();
        String row1 = "qwertyuiop";
        String row2 = "aasdfghjkl";
        String row3 = "zxcvbnm";

        for (int i=0; i<words.length; i++) {
            String curWord = words[i];  // get the current word in words list
            boolean inRow1 = true;
            boolean inRow2 = true;
            boolean inRow3 = true;
            
            // one loop to iterate word and check each row
            for (int j=0; j<curWord.length(); j++) {
                char curChar = Character.toLowerCase(curWord.charAt(j));
                if (row1.indexOf(curChar) == -1) {
                    inRow1 = false;
                }
                if (row2.indexOf(curChar) == -1) {
                    inRow2 = false;
                }
                if (row3.indexOf(curChar) == -1) {
                    inRow3 = false;
                }
            }

            // check if at least all letters in curWord are in 1 row
            if (inRow1 == true || inRow2 == true || inRow3 == true) {
                validWords.add(curWord);
            } 
            
        }

        String[] output = new String[validWords.size()];
        for (int i=0; i<validWords.size(); i++) {
            output[i] = validWords.get(i);
        }

        return output;
    }
}

// NOTE: convert each char to lower case before checking existence
