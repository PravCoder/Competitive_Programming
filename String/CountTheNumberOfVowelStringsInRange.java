class CountTheNumberOfVowelStringsInRange {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;

        for (int i=left; i<=right; i++) {
            String curWord = words[i];

            char first = curWord.charAt(0);
            char last = curWord.charAt(curWord.length()-1);
            
            boolean f = false;
            boolean l = false;
            if (first == 'a') {
                f = true;
            }
            if (first == 'e') {
                f = true;
            }
            if (first == 'i') {
                f = true;
            }
            if (first == 'o') {
                f = true;
            }
            if (first == 'u') {
                f = true;
            }


            if (last == 'a') {
                l = true;
            }
            if (last == 'e') {
                l = true;
            }
            if (last == 'i') {
                l = true;
            }
            if (last == 'o') {
                l = true;
            }
            if (last == 'u') {
                l = true;
            }

            if (f == true && l == true) {
                count ++;
            }
        }

        return count;
        
    }
}