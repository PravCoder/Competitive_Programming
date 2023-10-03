
class SecondLargestDigitString {
    public int secondHighest(String s) {
        // add all the digit characters to digits-list
        ArrayList<Integer> digits = new ArrayList<Integer>();
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur) == true) {
                digits.add(Character.getNumericValue(cur));
            }
        }
        // get the 1st-max-digit and add all the non-1st-max-digits to a new-list adn return the max of that
        int maxInt = this.getMax(digits);
        ArrayList<Integer> newDigits = new ArrayList<Integer>();
        for (Integer d: digits){
            if (d!=maxInt) {
                newDigits.add(d);
            }
        }
        return this.getMax(newDigits);

    }

    public int getMax(ArrayList<Integer> digits) {
        int maxInt = -1;
        for (int i=0; i<digits.size(); i++) {
            if (digits.get(i) > maxInt) {
                maxInt = digits.get(i);
            }
        }
        return maxInt;
    }
}

// NOTE: this is very bad solution...

// 1796. Second Largest Digit in a String