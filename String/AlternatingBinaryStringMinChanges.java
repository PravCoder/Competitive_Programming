
class AlternatingBinaryStringMinChanges {
    public int minOperations(String s) {

        int count1 = 0; // number of changes for 1st alternating sequnce with even-number as first
        int count2 = 0; // number of changes for 2nd alaternating sequence with odd-number as first
        // first-char is 1, so even-indcies are 1's odd indicies are 0's
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            // if even-index and its not 1 then we need to change it
            if (i%2 == 0 && cur != '1') {
                count1 += 1;
            } 
            // if odd-index and its not 0 then we need to change it
            else if (i%2 != 0 && cur != '0') {
                count1 += 1;
            }
        }
        // first-char is 0, so even-indcies are 0's odd indicies are 1's
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            // if even-index and its not 0 then we need to change it
            if (i%2 == 0 && cur != '0') {
                count2 += 1;
            } 
            // if odd-index and its not 1 we need to change it
            else if (i%2 != 0 && cur != '1') {
                count2 += 1;
            }
        }
        return Math.min(count1, count2);
        
    }
}
// 1758. Minimum Changes To Make Alternating Binary String