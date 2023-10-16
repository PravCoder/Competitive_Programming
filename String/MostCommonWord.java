import java.util.HashMap;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // convert all letters to lowercase, replace all nonalphanumeric characters before split
        String[] words = paragraph.toLowerCase().replaceAll("\\W+" , " ").split("\\s+");
        // stores word and number of occurances
        HashMap<String, Integer> nonBanned = new HashMap<String, Integer>();
        // iterate words
        for (String w: words) {
            // if it is not banned, add it to the keySet
            if (isBanned(w, banned) == false) {
                if (nonBanned.keySet().contains(w) == false) {
                    nonBanned.put(w, 1);
                }
                else if (nonBanned.keySet().contains(w) == true) {
                    nonBanned.put(w, nonBanned.get(w)+1);
                }
            }
        }
        // find the key in hashmap with max-value
        int maxCount = -1;
        String maxWord = "";
        for (String key: nonBanned.keySet()) {
            if (nonBanned.get(key) > maxCount) {
                maxCount = nonBanned.get(key);
                maxWord = key;
            }
        }
        return maxWord;
        
    }

    public boolean isBanned(String word, String[] banned) {
        for (String w: banned) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
// 819. Most Common Word

// Patterns: String Iteration. Character Count. Hashmap. Occurances of Character. 