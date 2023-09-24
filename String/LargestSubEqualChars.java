class LargestSubEqualChars {
    public int maxLengthBetweenEqualCharacters(String s) {

        int longest = -1;
        // iterate each character
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            // iterate from end until i-cur
            for(int j=s.length()-1;j>i;j--){
                // if they are equal calculate the distance between them and substract 1
                // to exclude right-end-point
                if (cur == s.charAt(j)) {
                    longest=Math.max(longest, Math.abs((j-i))-1);
                }
                
            }

        }
        return longest;
    }
}
// 1624. Largest Substring Between Two Equal Characters
