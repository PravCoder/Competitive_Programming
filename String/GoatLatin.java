import java.util.ArrayList;

class GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        ArrayList<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i=0; i<words.length; i++) {
            String curWord = words[i];
            char firstChar = curWord.charAt(0);
            if (vowels.contains(Character.toLowerCase(firstChar)) == true) {
                curWord += "ma";
            }
            else if (vowels.contains(Character.toLowerCase(firstChar)) ==false) {
                curWord = curWord.substring(1)+firstChar+"ma";
            }
            for (int j=0; j<i+1; j++) {
                curWord += "a";
            }
            words[i] = curWord;
        }
        return String.join(" ", words);
    }
}