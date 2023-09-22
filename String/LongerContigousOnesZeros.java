


class LongerContigousOnesZeros {
    public boolean checkZeroOnes(String s) {
        int longest0 = 0;
        int longest1 = 0;

        for (int i=0; i<s.length(); i++) {
            String sub0 = "";
            String sub1 = "";
            for (int j=i; j<s.length(); j++) {
                char cur = s.charAt(j);
                if (cur == '0') {
                    sub0 += cur;
                    longest0 = Math.max(sub0.length(), longest0);
                    sub1 = "";
                } 
                if (cur == '1') {
                    sub1 += cur;
                    longest1 = Math.max(sub1.length(), longest1);
                    sub0 = "";
                }
            }
            longest0 = Math.max(sub0.length(), longest0);
            longest1 = Math.max(sub1.length(), longest1);
        }


        System.out.println(longest1);
        System.out.println(longest0);
        if (longest1 > longest0) {
            return true;
        } else {
            return false;
        }
    }
}

// True-> more 1's
// False-> more 0's
// 1869. Longer Contiguous Segments of Ones than Zeros
