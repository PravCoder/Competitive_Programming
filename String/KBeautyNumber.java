class Solution {
    public int divisorSubstrings(int num, int k) {

        int count = 0;
        String digits = String.valueOf(num);
        // iterate digits of integger
        for (int i=0; i<digits.length(); i++) {
            String sub = "";
            // if length of k-substring is possible at current-index-i -1 for index
            if (i+(k-1) <= digits.length()-1) {
                // itearte length of substringa and add from i
                for (int j=0; j<k; j++) {
                    sub += digits.charAt(i+j);
                }
                System.out.println(sub);
                int curNum = Integer.parseInt(sub);
                if (curNum != 0 && num % curNum == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
// 2269. Find the K-Beauty of a Number