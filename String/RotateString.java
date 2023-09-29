class RotateString {
    public boolean rotateString(String s, String goal) {

        int i=0;
        String originalS = s;
        while (true) {
            s = s.substring(1, s.length())+s.charAt(0);
            if (s.equals(goal) == true) {
                return true;
            }
            // if s equals original state and its not the first iteration so some shift has been done.
            if (s.equals(originalS) && i!=0) {
                return false;
            }
            i += 1;

        }
    }
}
// 796. Rotate String
