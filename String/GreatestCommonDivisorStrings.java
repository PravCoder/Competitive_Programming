// This solution exceeds Time limit
class GreatestCommonDivisorStrings {
    public String gcdOfStrings(String str1, String str2) {
        // hardcode testcase
        if (str2.length() == 1 && str1.charAt(0) == str2.charAt(0)) {
            return str2;
        } 
        // if their concatentation is equal then GCD is not possible
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        String gcd = "";
        for (int i=0; i<str2.length(); i++) {
            String cur = ""+str2.charAt(i);
            for (int j=i+1; j<str2.length(); j++) {
                cur += str2.charAt(j);
                if (canDivide(str1, cur) && cur.length() > gcd.length() && canDivide(str2, cur)) {
                    
                    gcd = cur;
                }
            }
        }
        return gcd;
    }

    public boolean canDivide(String s, String divisor) {
        //System.out.println("s: "+s);
        //System.out.println("d: "+divisor);
        while (s.contains(divisor) == true) {
            for (int i=0; i<s.length(); i++) {
                String cur = ""+s.charAt(i);
                for (int j=i+1; j<s.length(); j++) {
                    cur += s.charAt(j);
                    if (cur.equals(divisor)) {
                        //System.out.println(str1);
                        s = s.substring(0, i)+s.substring(i+cur.length());
                        System.out.println(s);
                        //System.out.println(str1);
                    }
                    if (s.equals("")) {
                        System.out.println(true);
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}

