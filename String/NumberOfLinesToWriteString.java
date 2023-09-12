
class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        int totalLines = 0;
        int widthLast = 0;
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        // iterate letters
        for (int i=0; i<s.length(); i++) {
            char letter = s.charAt(i);  // get current letter
            // get width of letter using its index in widths
            int letterWidth = widths[alpha.indexOf(letter)];  
            if (widthLast + letterWidth > 100) {
                totalLines += 1;
                widthLast = letterWidth;
            }
            else if (widthLast + letterWidth <= 100) {
                widthLast += letterWidth;
            }
        }

        return new int[] {totalLines+1, widthLast};
    }

}