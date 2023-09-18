class StringMatchArray {
    public List<String> stringMatching(String[] words) {
        
        List<String> subs = new ArrayList<String>();

        for (int i=0; i<words.length; i++) {
            String cur = words[i];
            // iterate from i to end fo list
            // check if substring already exists
            for (int j=i+1; j<words.length; j++) {
                if (cur.contains(words[j]) && subs.contains(words[j]) == false) {
                    subs.add(words[j]);
                }
                else if (words[j].contains(cur) && subs.contains(cur) == false) {
                    subs.add(cur);
                }
            }
        }


        return subs;
    }

}
// 1408. String Matching in an Array
