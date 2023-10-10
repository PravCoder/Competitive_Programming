
class RemoveDigitFromNumToMaximizeResult {
    public String removeDigit(String number, char digit) {

        int maxResult = -1;  // stores  maximum decimal that can be formed after removing digit
        // iterate number-chars
        for (int i=0; i<number.length(); i++) {
            char cur = number.charAt(i);
            // if cur is equal to digit
            if (cur == digit) {
                // construct a new string exlcuding cur-i
                String newNum = number.substring(0, i)+number.substring(i+1, number.length());
                int newNumInt = Integer.valueOf(newNum); // get integer version of newnum-string and update max
                if (newNumInt > maxResult) {
                    maxResult = newNumInt;
                }
            }
        }
        return Integer.toString(maxResult);
    }
}

// 2259. Remove Digit From Number to Maximize Result

// Patterns: String Iteartions, Substring construction, Character Deletion. 
// NOTE: causes java.lang.NumberFormatException: For input string: "299858953917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471"