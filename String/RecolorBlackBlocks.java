
class RecolorBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        
        String mostBs = ""; // stores substring with most b-blocks
        int bCount = 0;     // stores number b-blocks in substring with most b-blocks
        // iterate all blocks in blocks-string
        for (int i=0; i<blocks.length(); i++) {
            String sub = "";
            int curbCount = 0; 
            // if substring of length-k is possible at current index
            if (i+(k-1) <= blocks.length()-1) {
                // iterate substring-length
                for (int j=0; j<k; j+=1) {
                    sub += blocks.charAt(i+j);  // add char-blocks to cur-sub-string
                    // keep track of number of b-blocks in cur-sub-string
                    if (blocks.charAt(i+j) == 'B') {
                        curbCount += 1;
                    }
                }
            }
            // update count of most B's in substring
            if (curbCount > bCount) {
                mostBs = sub;
                bCount = curbCount;
            }
            System.out.println(sub + " " +curbCount);
        }
        // return the number of W-blocks in substring with most B's by substracting k-bCount
        // which also gives the number of blocks we need to recolor
        return k-bCount;
    }
}


// "WBBWWBBWBW"
// NOTE: find contigous substring of length k with the most 'B' blocks
// 2379. Minimum Recolors to Get K Consecutive Black Blocks