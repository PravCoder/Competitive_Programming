
class ShortestComlpetingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        String plateStr = "";
        int minLen = Integer.MAX_VALUE;
        String shortest = "";

        for (int i=0; i<licensePlate.length(); i++) {
            char cur = licensePlate.charAt(i);
            if (Character.isAlphabetic(cur) == true) {
                plateStr += Character.toLowerCase(cur);
            }   
        }
        for (String w: words) {
            boolean completing = true;
            System.out.println("-----");
            System.out.println("Word: " + w);
            for (int i=0; i<plateStr.length(); i++) {
                char cur = plateStr.charAt(i);
                System.out.println("Cur char: " + cur);
                // if it occurs less than in cur-word than in plate is not completing
                if (this.countChar(w, cur) < this.countChar(plateStr, cur)) {
                    System.out.println(this.countChar(w, cur)  +"<"+this.countChar(plateStr, cur));
                    completing = false;
                }
            }
            // only replace it if its less than cur-min-length, so we get the first occurance of shortest completing
            if (completing == true && w.length() < minLen) {
                shortest = w;
                minLen = w.length();
            }
        }
        return shortest;
    }

    public int countChar(String str, char c) {
        int count = 0;
        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
                count++;
        }

        return count;
    }
}
// 748. Shortest Completing Word