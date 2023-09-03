

class WordEqualsSumOfWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        String firstDigits = "";
        String secondDigits = "";
        String targetDigits = "";

        for (int i=0; i<firstWord.length(); i++) {
            firstDigits += alpha.indexOf(firstWord.charAt(i));
        }
        for (int i=0; i<secondWord.length(); i++) {
            secondDigits += alpha.indexOf(secondWord.charAt(i));
        }
        for (int i=0; i<targetWord.length(); i++) {
            targetDigits += alpha.indexOf(targetWord.charAt(i));
        }

        int firstInt = Integer.parseInt(firstDigits);
        int secondInt = Integer.parseInt(secondDigits);
        int targetInt = Integer.parseInt(targetDigits);

        if (firstInt+secondInt == targetInt) {
            return true;
        } else {
            return false; 
        }
    }     
}