class ExcelSheetColumn {
    public int titleToNumber(String columnTitle) {
        int result = 0;  // stores column-number
        // for getting the index of a letter in the alphabet
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        // iterate each letter in column-title-string
        for (int i = 0; i < columnTitle.length(); i++) {
            char letter = columnTitle.charAt(i);  // get cur-letter
            letter = Character.toLowerCase(letter); // convert to lower case
            int value = alpha.indexOf(letter)+1;  // get letter index in alphabet
            result = result * 26 + value; //multiply result by 26 to iterate alphabet and add the second letter-index
        }

        return result;
    }
}
// 171. Excel Sheet Column Number
