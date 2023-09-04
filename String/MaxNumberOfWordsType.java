import java.util.Arrays;

    public class MaxNumberOfWordsType {

        public int canBeTypedWords(String text, String brokenLetters) {

            int correctWords = 0;
            String[] words = text.split(" ", -1);
            System.out.println(Arrays.toString(words));

            for (int i=0; i<words.length; i++) {
                String curWord = words[i];
                boolean valid = true;  // true if all letters in word are not in broken
                for (int j=0; j<curWord.length(); j++) {
                    if (brokenLetters.indexOf(curWord.charAt(j)) != -1) { // -1, char not in broken, we can type char
                        valid = false;
                        break;
                    }
                }
                if (valid == true) {
                    correctWords += 1;
                }
            }

            return correctWords;
            
        }
}
