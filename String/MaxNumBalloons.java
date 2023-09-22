import java.util.HashMap;

class MaxNumBalloons {
    public int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        String balloon = "balloon";
        HashMap<Character, Integer> ballCount = new HashMap<Character, Integer>();
        ballCount.put('b', this.getCount(balloon, 'b'));  // get required coutsn of character in balloon
        ballCount.put('a', this.getCount(balloon, 'a'));  // to make more dynamic for not just balloon stirng
        ballCount.put('l', this.getCount(balloon, 'l'));
        ballCount.put('o', this.getCount(balloon, 'o'));
        ballCount.put('n', this.getCount(balloon, 'n'));

        // ge teh counts of each character in balloon thats in text
        for (int i=0; i<text.length(); i++) {
            char letter = text.charAt(i);
            if (count.keySet().contains(letter) == false && balloon.contains(String.valueOf(letter))) {
                count.put(letter, 1);
            } 
            else if (count.keySet().contains(letter) == true && balloon.contains(String.valueOf(letter))) {
                count.put(letter, count.get(letter)+1);
            }
        }

        int total = Integer.MAX_VALUE; // Initialize total with a large value
        // iterate balloon string
        for (char letter : balloon.toCharArray()) {
            // if cur-letter exists in count-keys
            if (count.keySet().contains(letter)) {
                int letterCount = count.get(letter); // get cur-letter number of occurances in text
                int requiredCount = ballCount.get(letter); // get reqired number of occurances of letter in balloon
                int instances = letterCount / requiredCount; // get number of instances  actual-count/needed-count
                // we can only create as much balloon-string as the min-occurances of letter in text
                total = Math.min(total, instances); 
            } else {
                return 0; // Required letter is missing
            }
        }

        return total;

    }

    public int getCount(String s, char letter) {
        int c = 0;
        for (char t : s.toCharArray()) {
            if (t == letter) {
                c += 1;
            }
        }
        return c;
    }
}
//  1189. Maximum Number of Balloons      

        
                