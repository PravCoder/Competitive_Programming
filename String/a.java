class Yes {
    public static boolean checkOnesSegment(String s) {

        int oneSegments = 0;

        int i =0;
        while (i<s.length()-1) {
            if (s.charAt(i) == '1') {
                int count = 1;
                int j = i+1;
                while (j <s.length()-1 && s.charAt(j) == '1') {
                    count += 1;
                    j += 1;
                }
                if (count > 1) {
                    oneSegments += 1;
                    i += count-1;
                }
            }
            i += 1;
        }
        
        if (oneSegments > 1 || oneSegments == 0) {
            return false;
        }
        return true;
        
    }

    public static void main(String args[]) {
        System.out.println(checkOnesSegment("100"));
    }
}