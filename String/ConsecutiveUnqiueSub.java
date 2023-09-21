
class ConsecutiveUnqiueSub {
    public int maxPower(String s) {

        int maxLength = 0;
        String maxSub = "";
        for (int i=0; i<s.length(); i++) {
            String curSub = ""+s.charAt(i);  // add base-character to substring
            for (int j=i+1; j<s.length(); j++) {
                // if next-char is not equal base-character, then substring cant contain one unique character
                if (s.charAt(j) != curSub.charAt(0)) {  
                    break;
                } else {
                    curSub += s.charAt(j);
                    maxLength = Math.max(curSub.length(), maxLength);
                    maxSub = curSub;
                }
            }
        }


        System.out.println(maxSub);
        if (maxLength == 0 && s.length() > 0){
            return 1;
        }
        return maxLength;
    }
}
// 1446. Consecutive Characters
