import java.util.ArrayList;

class CalculateDigitSumString {
    public String digitSum(String s, int k) {

        // whiel s-string length is greater than k keep applying operatins
        while (s.length() > k) {
            // whiel s-length cannot be split evenly into groups, add zero to not effect sum
            while (s.length()%k != 0){
                s += "0";
            }
            // iterate s string with step=k
            ArrayList<String> groups = new ArrayList<String>();
            for (int i=0; i<s.length(); i += k) {
                String curGroup = "";
                // iterate from cur-i to i+k to get characters of current group
                for (int j=i; j<i+k; j++) {
                    curGroup += s.charAt(j);
                }
                groups.add(curGroup);  // add string-group
            }
            
            // iterate each gorup
            for (int i=0; i<groups.size(); i++) {
                String cur = groups.get(i); // get current group
                int curGroupSum = 0;  // stores digit sum of cur-grop-str
                // iterate the cur-group-string
                for (int j=0; j<cur.length(); j++) {
                    // add each integer digit to its sum
                    curGroupSum += Character.getNumericValue(cur.charAt(j));
                }
                // replace it with its new digits sum as a stirng in gorups
                groups.set(i, String.valueOf(curGroupSum));
            }
            // add all teh groups into 1 string and set s as this newstring, return s-string
            String newS = "";
            for (String a: groups) {
                newS += a;
            }
            s = newS;
        }
        return s;
    }
}


// 2243. Calculate Digit Sum of a String