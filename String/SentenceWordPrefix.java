
class SentenceWordPrefix {
    public int isPrefixOfWord(String sentence, String searchWord) {

        // split sentce into wrods
        String[] words = sentence.split(" ");
        // iterate words
        for (int i=0; i<words.length; i++) {
            String curWord = words[i]; // get cur-word

            // if searchWord as prefix is possible
            if (curWord.length() >= searchWord.length()) {
                String curPrefix = "";
                for (int j=0; j<searchWord.length(); j++) { // iterate prefix indicies
                    curPrefix += curWord.charAt(j);
                }
                if (curPrefix.equals(searchWord) == true) { // check prefix equaivalent
                    return i+1;  // 1-indexed
                }
            }
        }
        return -1;
    }
}

// 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
