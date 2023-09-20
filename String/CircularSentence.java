
class CircularSentence {
    public boolean isCircularSentence(String sentence) {

        String[] words = sentence.split(" ");

        for (int i=0; i<words.length; i++) {
            String cur = words[i];
            if (i+1 <= words.length-1) {
                String next = words[i+1];
                if (cur.charAt(cur.length()-1) != next.charAt(0)) {
                    return false;
                }
            }
            else if (i == words.length-1) {
                if (cur.charAt(cur.length()-1) != words[0].charAt(0) ) {
                    return false;
                }
            }
        }
        return true;
        
    }
}
// 2490. Circular Sentence
