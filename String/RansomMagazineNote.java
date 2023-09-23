import java.util.HashMap;

class RansomMagazineNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> magCount = new HashMap<Character, Integer>();
        HashMap<Character, Integer> ransomCount = new HashMap<Character, Integer>();

        for (int i=0; i<magazine.length(); i++) {
            char cur = magazine.charAt(i);
            if (magCount.keySet().contains(cur) == false) {
                magCount.put(cur, 1);
            }
            else if (magCount.keySet().contains(cur) == true) {
                magCount.put(cur, magCount.get(cur)+1);
            }
        }
        for (int i=0; i<ransomNote.length(); i++) {
            char cur = ransomNote.charAt(i);
            if (ransomCount.keySet().contains(cur) == false) {
                ransomCount.put(cur, 1);
            }
            else if (ransomCount.keySet().contains(cur) == true) {
                ransomCount.put(cur, ransomCount.get(cur)+1);
            }
        }

        for (Character letter: ransomCount.keySet()) {
            if (magCount.keySet().contains(letter) == true && magCount.get(letter) < ransomCount.get(letter)) {
                return false;
            }
            else if (magCount.keySet().contains(letter) == false) {
                return false;
            }
        }
        return true;
    }
}
// 383. Ransom Note
