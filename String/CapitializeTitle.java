
class CapitializeTitle {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            if (word.length() <= 2) {
                words[i] = word.toLowerCase();
            } else {
                String newWord = word.toLowerCase();
                newWord = Character.toUpperCase(newWord.charAt(0))+newWord.substring(1, newWord.length());
                words[i] = newWord;
            }
        }
        return String.join(" ", words);
    }
}
// 2129. Capitalize the Title
