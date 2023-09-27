
class MaxScoreSplitString {
    public int maxScore(String s) {
        int score = 0;
        // the left-sub-string will be built by the outer loop
        String leftSub = "";
        for (int i=0; i<s.length()-1; i++) {
            leftSub += s.charAt(i);
            // the right-substring will be built by inner loop which iterates from cur to end of string
            String rightSub = "";
            for (int j=i+1; j<s.length(); j++) {
                rightSub += s.charAt(j);
            }
            int leftZeroCount = 0;
            int rightOneCount = 0;
            for (int l=0; l<leftSub.length(); l++) {
                if (leftSub.charAt(l) == '0') {
                    leftZeroCount += 1;
                }
            }
            for (int r=0; r<rightSub.length(); r++) {
                if (rightSub.charAt(r) == '1') {
                    rightOneCount += 1;
                }
            }
            if (leftZeroCount+rightOneCount >= score) {
                score = leftZeroCount+rightOneCount;
            }
        }
        return score;
        
    }
}
// 1422. Maximum Score After Splitting a String
