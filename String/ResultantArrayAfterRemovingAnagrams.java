import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ResultantArrayAfterRemovingAnagrams {
    
    public List<String> removeAnagrams(String[] words) {
        List<String> wordsArr = new ArrayList<String>();
        for (String w: words) {
            wordsArr.add(w);
        }

        while (this.hasAnagrams(wordsArr) == true) {
            for (int i=1; i<wordsArr.size(); i++) {
                String cur = wordsArr.get(i);
                String prev = wordsArr.get(i-1);
                if (this.areAnagrams(prev, cur) == true) {
                    wordsArr.remove(i);  // if adjacent anagram remove it
                }
            }
        }
        return wordsArr;
    }

    // Returns true if any adjacent string in array are anagrams
    public boolean hasAnagrams(List<String> wordsArr) {
        for (int i=1; i<wordsArr.size(); i++) {
            String cur = wordsArr.get(i);
            String prev = wordsArr.get(i-1);
            if (this.areAnagrams(prev, cur) == true) {
                return true;
            }
        }
        return false;
    }
    

    // Check if 2 string are anagrams by create hashmap of counts for each string and checking if they are equal
    public boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create character frequency maps
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        // Compare character frequency maps
        return map1.equals(map2);
    }
}
// 2273. Find Resultant Array After Removing Anagrams