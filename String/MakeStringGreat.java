class Solution {

    public String makeGood(String s) {

        while (this.isGreat(s) == false) {
            for (int i=0; i<s.length(); i++) {
                if (i+1 <= s.length()-2 && Character.toUpperCase(s.charAt(i))==Character.toUpperCase(s.charAt(i+1))) {
                    if (Character.isUpperCase(s.charAt(i)) == true && Character.isUpperCase(s.charAt(i+1)) == false) {
                        s = s.substring(0, i) + s.substring(i+2);
                        break;
                    }
                    if (Character.isUpperCase(s.charAt(i)) == false && Character.isUpperCase(s.charAt(i+1)) == true) {
                        s = s.substring(0, i) + s.substring(i+2);
                        break;
                    }
                }
            }
        }
        if (s.length() == 2 && Character.toUpperCase(s.charAt(0))==Character.toUpperCase(s.charAt(1))) {
            return "";
        }
        
        return s;
    }
    public boolean isGreat(String s) {
        for (int i=0; i<s.length(); i++) {
            if (i+1 <= s.length()-2 && Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(s.charAt(i+1))) {
                if (Character.isUpperCase(s.charAt(i)) == true && Character.isUpperCase(s.charAt(i+1)) == false) {
                    return false;
                }
                if (Character.isUpperCase(s.charAt(i)) == false && Character.isUpperCase(s.charAt(i+1)) == true) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
// 1544. Make The String Great

// Wrong Answer 333 / 334 testcases passed

