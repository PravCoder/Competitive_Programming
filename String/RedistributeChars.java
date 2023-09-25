import java.util.HashMap;

class RedistributeChars {
    public boolean makeEqual(String[] words) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char cur = words[i].charAt(j);
                if (map.keySet().contains(cur) == true) {
                    map.put(cur, map.get(cur)+1);
                } else {
                    map.put(cur, 1);
                }
            }
        }
        // if number of occurances of character is not divisible by number of words, cant make every string equal
        for(char ch: map.keySet()){
            if (map.get(ch)%words.length!=0) {
                return false;
            }
        }
        return true;
    }
}
// 1897. Redistribute Characters to Make All Strings Equal