
class LargestSameThreeDigitNumber {
    public String largestGoodInteger(String num) {

        int maxDigit = -1;
        String maxSub = "";

        for (int i=0; i<num.length(); i++) {
            String sub = ""+num.charAt(i);
            char baseDigit = sub.charAt(0);
            int curDigit = Character.getNumericValue(baseDigit);
            for (int j=i+1; j<num.length(); j++) {
                if (num.charAt(j) == baseDigit) {
                    sub += num.charAt(j);   
                    if (sub.length() == 3 && curDigit > maxDigit) {
                        maxDigit = curDigit;
                        maxSub = sub;
                    }
                }
                else if (num.charAt(j) != baseDigit) {
                    break;
                }
            }
        }
        return maxSub;
    }
}
// 2264. Largest 3-Same-Digit Number in String