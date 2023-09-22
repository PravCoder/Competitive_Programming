
class FirstUniqueChar {
    public int firstUniqChar(String s) {

        for (int i=0; i<s.length(); i++) {
            if (this.getCount(s, s.charAt(i)) == 1) { // first occurance iterate from start to end
                return i;  // index
            }
        }
        return -1; // if no unqiue characters exist
    }

    public int getCount(String s, char letter) {
        int c = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == letter) {
                c += 1;
            }
        }
        return c;
    }
}
// 387. First Unique Character in a String
// Time limit exceeded