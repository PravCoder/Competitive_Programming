
class LargestValueOddInteger {
    public String largestOddNumber(String num) {

        int largestOdd = 0;
        String largestStr = "";

        // iterate each digit
        for (int i=0; i<num.length(); i++) { 
            String sub = "";
            // iterate from inclsuive current digit to end of string
            for (int j=i; j<num.length(); j++) {
                sub += num.charAt(j);
                int subNum = Integer.parseInt(sub);
                // at each addition of digit check if it is the largest-valued odd integer
                if (subNum > largestOdd && subNum%2 != 0) {
                    largestOdd = subNum;
                    largestStr = sub;
                }
            }
        }
        
        return largestStr;
    }
}
// 1903. Largest Odd Number in String
// Error: java.lang.NumberFormatException: For input string: "7542351161"