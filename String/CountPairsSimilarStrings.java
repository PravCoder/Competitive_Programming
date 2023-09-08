import java.util.HashSet;

class CountPairsSimilarStrings {

    public int similarPairs(String[] words) {
        int count = 0;

        for (int i=0; i<words.length; i++) {
            String iWord = words[i];
            for (int j=i+1;j<words.length; j++) {
                String jWord = words[j];
                if (i != j && this.areSimilar(iWord, jWord) == true) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public boolean areSimilar(String a, String b) {
        // hashset provides no duplicate elements
        // and fast equalancy check instead of checking each element
        // individually
        HashSet<Character> aset=new HashSet<Character>();
        for(char ch:a.toCharArray())
            aset.add(ch);

        HashSet<Character> bset=new HashSet<Character>();
        for(char ch:b.toCharArray())
            bset.add(ch);
        return aset.equals(bset)?true:false;
    }
}