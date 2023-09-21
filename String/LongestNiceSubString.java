
class LongestNiceSubString {
    public String longestNiceSubstring(String s) {

        int maxLength = 0;
        String maxSub = "";

        for (int i=0; i<s.length(); i++) {
            String curSub = ""+s.charAt(i);
            for (int j=i+1; j<s.length(); j++) {
                curSub += s.charAt(j);
                if (this.isNice(curSub) == true) {
                    System.out.println(curSub + " " +maxLength);
                    if (curSub.length() > maxLength) {
                        maxLength = curSub.length();
                        maxSub = curSub;
                    }
                }
            }
        }
        return maxSub;
        
    }

    public boolean isNice(String s) {
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isUpperCase(cur) == true && s.contains(String.valueOf(Character.toLowerCase(cur))) ==false) {
                return false;
            }
            if (Character.isLowerCase(cur)==true && s.contains(String.valueOf(Character.toUpperCase(cur))) ==false) {
                return false;
            }
        }
        return true;
    }
}
// 1763. Longest Nice Substring
