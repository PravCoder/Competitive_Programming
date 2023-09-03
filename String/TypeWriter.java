class TypeWriter {
    public int minTimeToType(String word) {

        char prev = 'a';
        int operations = word.length();

        for (int i=0; i<word.length(); i++) {
            char letter = word.charAt(i);
            int diff = Math.abs(letter - prev);
            operations += Math.min(diff, 26-diff);  // min of clockwise adn counter clockwise distances
            prev = letter;
        }
        return operations;
    }
}