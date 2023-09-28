
class DetectCapital {
    public boolean detectCapitalUse(String word) {

        int numUpper = 0;
        int numLower = 0;
        boolean isFirstUpper = false;
        if (Character.isUpperCase(word.charAt(0)) == true) {
            isFirstUpper = true;
        }
        for (int i=0; i<word.length(); i++) {
            char cur = word.charAt(i);
            if (Character.isUpperCase(cur) == true) {
                numUpper += 1;
            }
            if (Character.isLowerCase(cur) == true) {
                numLower += 1;
            }
        }

        // check each condition, statements can be condensended
        if (numUpper == word.length()){
            return true;
        }
        if (numLower == word.length()) {
            return true;
        }
        if (isFirstUpper == true && numLower == word.length()-1) {
            return true;
        }
        return false;
        
    }
}
// 520. Detect Capital