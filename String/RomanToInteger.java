import java.util.HashMap;
class RomanToInteger {
    public int romanToInt(String s) {

        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);  // add conversions to hahsmap
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);

        int total = 0;
        // iterate each character
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);  
            // if next char is possible and next is less than cur, then subtract cur, when we go to next we add it
            // to get its difference
            if (i+1 <= s.length()-1 && table.get(s.charAt(i+1)) > table.get(cur)) {
                total -= table.get(cur);
            } else {
                total += table.get(cur); 
            }
            
        }
        return total;
        
    }
}
// 13. Roman to Integer