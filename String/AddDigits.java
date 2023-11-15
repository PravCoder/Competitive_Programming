class AddDigits {
    public int addDigits(int num) {
        
        // convert int to string
        String nStr = String.valueOf(num);  
        // while string as more than 1 digit to sum
        while (nStr.length() > 1) {
            // iterate chars of cur-n-string and sum
            int digitSum = 0;
            for (int i=0; i<nStr.length(); i++) {
                digitSum += Character.getNumericValue(nStr.charAt(i));
            }
            // set new value of nStr as its digit sum
            nStr = String.valueOf(digitSum);
        }
        // convert last state of nstr into iteger
        return Integer.parseInt(nStr);
        
    }
}
// 258. Add Digits