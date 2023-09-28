
class FancyString {
    public String makeFancyString(String s) {

       StringBuilder result = new StringBuilder (); // stores resultant string
        char prev = s.charAt(0); // stores previous-character
        result.append(prev); // add precious character to result
        int freq = 1;  // stores the number of occurances we ahve encountered so far in string

        // iterate from second-char to end of string
        for (int i=1; i<s.length(); i++) {
            char cur = s.charAt(i);  // get current character
            if (cur == prev) { // increment freeuqncy if cur-char is equal to prev-char
                freq += 1;
            } 
            if (cur != prev) { // if cur-char and prev-char are not equal reset frequency and increment prev-char
                prev = cur;
                freq = 1;
            }
            // if this character doesnt have 3 consecutive characters add it to result-string
            if (freq < 3) {
                result.append(cur);
            }
        }
        return result.toString();
    }
}
// 1957. Delete Characters to Make Fancy String