import java.util.HashMap;

class RemoveLetterToEqualizeFreq {
    public boolean equalFrequency(String word) {
        // iterate word and get the substring without the current i-char
        for (int i=0; i<word.length(); i++) {
            String curSub = word.substring(0, i)+word.substring(i+1, word.length());
            // if this current substring without i-char is valid
            if (this.isValidFreq(curSub) == true) {
                return true;
            }
        }
        return false;
    }

    // retruns true if every character has the same frequency
    public boolean isValidFreq(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (count.containsKey(cur) == true) {
                count.put(cur, count.get(cur)+1);
            }
            else if (count.containsKey(cur) == false) {
                count.put(cur, 1);
            }
        }

        int x = -1;
        for (Character k: count.keySet()) {
            int c = count.get(k);
            if (x == -1) {
                x = c;
            }
            else if (x != -1) {
                if (x != c) {
                    return false;
                }
            }
        }
        return true;
    }
}

// 2423. Remove Letter To Equalize Frequency