
class ThousandSeperator {
    public String thousandSeparator(int n) {

        String nStr = Integer.toString(n); // convert integer to string for digit iterations
        // if thousandths place is not possible
        if (nStr.length() <= 3) {
            return nStr;
        }

        int k=1; // counting the place we are in
        // itearte string backwards
        for (int i=nStr.length()-1; i>0; i--) {
            if (k == 3) { // group of 3 means we have reached a thounsandths place
                // add dot in current i-index
                nStr = nStr.substring(0, i)+"."+nStr.substring(i, nStr.length());
                k = 1;  // reset back to one's place
            } else {
                k += 1; // increment to next place
            }
        }
        return nStr;
        
    }
}

// 1556. Thousand Separator
