class Solution {
    public String greatestLetter(String s) {

        String alpha = "abcdefghijklmnopqrstuvwxyz";

        int greatestVal = -1;
        String greatestLetter = "";


        for (int i=0; i<s.length(); i++) {
            char curChar = s.charAt(i);
            char lowerChar = Character.toLowerCase(curChar);
            char upperChar = Character.toUpperCase(curChar);
            if (s.indexOf(lowerChar) != -1 && s.indexOf(upperChar) != -1 && alpha.indexOf(lowerChar) > greatestVal) {
                greatestVal = alpha.indexOf(lowerChar);
                greatestLetter = Character.toString(upperChar);
            }
        }

        return greatestLetter;
        
    }
}