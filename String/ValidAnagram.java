class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (sMap.keySet().contains(cur) == false) {
                sMap.put(cur, 1);
            }
            else if (sMap.keySet().contains(cur) == true) {
                sMap.put(cur, sMap.get(cur)+1);
            }
        }
        for (int i=0; i<t.length(); i++) {
            char cur = t.charAt(i);
            if (tMap.keySet().contains(cur) == false) {
                tMap.put(cur, 1);
            }
            else if (tMap.keySet().contains(cur) == true) {
                tMap.put(cur, tMap.get(cur)+1);
            }
        }
        
        for (Character c: sMap.keySet()) {
            if (tMap.containsKey(c) == false) {
                System.out.println("Fail 1");
                return false;
            }
            if (tMap.containsKey(c) == true && tMap.get(c) != sMap.get(c)) {
                System.out.println("Fail 2");
                return false;
            }
        }
        for (Character c: tMap.keySet()) {
            if (sMap.containsKey(c) == false) {
                return false;
            }
            if (sMap.containsKey(c) == true && sMap.get(c) != tMap.get(c)) {
                return false;
            }
        }
        return true;
        
    }
}




// 242. Valid Anagram
