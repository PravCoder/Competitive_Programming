
class MinMovesToConvertString {
    public int minimumMoves(String s) {
        int i = 0;  // index of current characte
        int operations = 0; // number groups of 3 of 'X' that we change to 'O'
        // iterate from beginng to end of s-string
        while(i < s.length()){
            // if cur is X move cur-indx to 3 and we just did an operations
            if (s.charAt(i)=='X') {
                i += 3;
                operations += 1;
            }
            // else increment i by 1 as usual
            else {
                i += 1;
            }
                
        }
        return operations;
    }
}
// 2027. Minimum Moves to Convert String


// Fails 1 testcase
class Solution {
    public int minimumMoves(String s) {

        int operations = 0;

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            int leftXcount = 0;
            int rightXcount = 0;
            if (cur == 'X') {
                if (i-2 >= 0) {
                    leftXcount += getCount('X', s.substring(i-2, i+1));
                    System.out.println("left: " +s.substring(i-2, i+1));
                }
                if (i+2 <= s.length()-1) {
                    rightXcount += getCount('X', s.substring(i, i+3));
                    System.out.println("right: " +s.substring(i, i+3));
                }
            }

            System.out.println("l: "+leftXcount+" r: "+rightXcount + " c: " +i);
            System.out.println(s);
            if (leftXcount > rightXcount) {
                for (int j=i-3; j<i+1; j++) {
                    if (s.charAt(j) == 'X') {   
                        s = s.substring(0, j)+'O'+s.substring(j+1, s.length());
                    }
                }
                operations += 1;
            }
            if (rightXcount > leftXcount) {
                for (int j=i; j<i+3; j++) {
                    if (s.charAt(j) == 'X') {   
                        s = s.substring(0, j)+'O'+s.substring(j+1, s.length());
                    }
                }
                operations += 1;
            }
            System.out.println(s);
            System.out.println("-------");
        }
        return operations;
        
    }

    public int getCount(Character c, String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c) {
                count += 1;
            }
        }
        return count;
    }
}