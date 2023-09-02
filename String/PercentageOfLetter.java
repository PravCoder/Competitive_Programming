public class PercentageOfLetter {
    
    public int percentageLetter(String s, char letter) {
        
        int matches = 0;

        for (int i=0; i<s.length(); i++) {
            char character = s.charAt(i);
            if (character == letter) {
                System.out.println("Aa");
                matches += 1;
            }
        }
        System.out.println(matches);
        return (100*matches)/s.length();
    }
}
