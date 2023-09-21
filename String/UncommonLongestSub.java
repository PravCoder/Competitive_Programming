
class UncommonLongestSub {
    public int findLUSlength(String a, String b) {
        if (a.equals(b) == true) {
            return -1;
        }

        int longestLength = -1;
        String longestSub = "";
        // check all substring of a-string if they exists in b
        for (int i=0; i<a.length(); i++) {
            String sub = ""+a.charAt(i);
            for (int j=0; i<a.length(); i++) {
                if (i!=j) {
                    sub += a.charAt(j);
                    if (this.isExists(b, sub) == false) {
                        longestLength = Math.max(sub.length(), longestLength);
                        longestSub = sub;
                    }
                }
            }
        }
        // check all substring of b-string if they exists in a
        for (int i=0; i<b.length(); i++) {
            String sub = ""+b.charAt(i);
            for (int j=0; i<b.length(); i++) {
                if (i!= j) {
                    sub += b.charAt(j);
                    if (this.isExists(a, sub) == false) {
                        longestLength = Math.max(sub.length(), longestLength);
                        longestSub = sub;
                    }
                }
            }
        }
        System.out.println(longestSub);
        return longestLength;

        
    }

    public boolean isExists(String a, String sub) {
        for (int i=0; i<a.length(); i++) {
            String curSub = ""+a.charAt(i);
            for (int j=0; j<a.length(); j++) {
                if (i!=j) {
                    curSub += a.charAt(j);
                    if (curSub.equals(sub) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
// NOTE: substring doesnt have to be contigious
// 521. Longest Uncommon Subsequence I