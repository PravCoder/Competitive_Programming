import java.util.HashMap;

class CountCommonWordsWithOneOccurance {
    public int countWords(String[] words1, String[] words2) {
        // Arrays.asList(yourArray).contains(yourValue) 

        int count = 0;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();

        for (int i=0; i<words1.length; i++) {
            String curWord = words1[i];
            if (map1.containsKey(curWord) == false) {
                map1.put(curWord, 1);
            }
            else if (map1.containsKey(curWord) == true) {
                map1.put(curWord, map1.get(curWord)+1);
            }
        }

        for (int i=0; i<words2.length; i++) {
            String curWord = words2[i];
            if (map2.containsKey(curWord) == false) {
                map2.put(curWord, 1);
            }
            else if (map2.containsKey(curWord) == true) {
                map2.put(curWord, map2.get(curWord)+1);
            }
        }

        for (String word: map1.keySet()) {
            if (map2.containsKey(word) == true && map1.get(word) == 1 && map2.get(word) == 1 ) {
                count += 1;
            }
        }

        return count;
        
    }
}