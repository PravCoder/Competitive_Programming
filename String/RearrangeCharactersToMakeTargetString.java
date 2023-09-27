import java.util.HashMap;

class RearrangeCharactersToMakeTargetString {

    public int rearrangeCharacters(String s, String target) {

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        HashMap<Character, Integer> targetCount = new HashMap<Character, Integer>();
        // iterate characters of target-string and add the occurances of each uqiue character in hashmap
        for (int i=0; i<target.length(); i++) {
            char cur = target.charAt(i);
            if (targetCount.keySet().contains(cur) == false) {
                targetCount.put(cur, this.getCount(target, cur));
            }
        }
        // get the counts of each character in target thats in text
        for (int i=0; i<s.length(); i++) {
            char letter = s.charAt(i);
            if (count.keySet().contains(letter) == false && target.contains(String.valueOf(letter))) {
                count.put(letter, 1);
            } 
            else if (count.keySet().contains(letter) == true && target.contains(String.valueOf(letter))) {
                count.put(letter, count.get(letter)+1);
            }
        }

        int total = Integer.MAX_VALUE; // Initialize total with a large value
        // iterate target string
        for (char letter : target.toCharArray()) {
            // if cur-letter exists in count-keys
            if (count.keySet().contains(letter)) {
                int letterCount = count.get(letter); // get cur-letter number of occurances in s-string
                int requiredCount = targetCount.get(letter); // get reqired number of occurances of letter in target-str
                int instances = letterCount / requiredCount; // get number of instances  actual-count/needed-count
                // we can only create as much target-string as the min-occurances of letter in s-string
                total = Math.min(total, instances); 
            } else {
                return 0; // Required letter is missing
            }
        }

        return total;
    }

    public int getCount(String s, char letter) {
        int c = 0;
        for (char t : s.toCharArray()) {
            if (t == letter) {
                c += 1;
            }
        }
        return c;
    }
        
    
}
// 2287. Rearrange Characters to Make Target String