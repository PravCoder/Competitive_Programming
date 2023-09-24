class FindDuplicate {
    public char findTheDifference(String s, String t) {

        for (int i=0; i<t.length(); i++) {
            char cur = t.charAt(i);
            // a char that exists in s can also be added to t
            // check if the number of occurances of each character
            if (countChar(s, cur) < countChar(t, cur)) {
                return cur;
            }
        }
        return 'z';
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
// 389. Find the Difference
