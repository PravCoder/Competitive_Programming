import java.util.ArrayList;
import java.util.HashMap;

class UncommonWords {
    public String[] uncommonFromSentences(String s1, String s2) {

        ArrayList<String> uncommon = new ArrayList<String>();

        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");

        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();

        // get occurances eof each word in each sentence and put in respective maps
        for (String w1: s1Words) {
            if (map1.keySet().contains(w1) == true) {
                map1.put(w1, map1.get(w1)+1);
            } else {
                map1.put(w1, 1);
            }
        }
        for (String w2: s2Words) {
            if (map2.keySet().contains(w2) == true) {
                map2.put(w2, map2.get(w2)+1);
            } else {
                map2.put(w2, 1);
            }
        }

        // find uncommon words in each map
        for (String w1: map1.keySet()) {
            if (map2.keySet().contains(w1) == false && map1.get(w1) == 1) {
                uncommon.add(w1);
            }
        }
        for (String w2: map2.keySet()) {
            if (map1.keySet().contains(w2) == false && map2.get(w2) == 1) {
                uncommon.add(w2);
            }
        }
        // convert to primitive array
        String[] output = new String[uncommon.size()];
        for (int i=0; i<uncommon.size(); i++) {
            output[i] = uncommon.get(i);
        }
        return output;
        
    }
}