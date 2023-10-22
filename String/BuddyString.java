


// SOLUTION 1: TIME LIMIT EXCEEDED
class BuddyString {
    public boolean buddyStrings(String s, String goal) {

        if (s.length() < 2) {
            return false;
        }

        for(int i=0; i<s.length(); i++) {
            for (int j=i+1; j<s.length(); j++) {
                String swapped = s.substring(0, i)+s.charAt(j)+s.substring(i+1, j)+s.charAt(i)+s.substring(j+1);
                // System.out.println(swapped);
                if (swapped.equals(goal) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}

// // 859. Buddy Strings
// Patterns: Substring Indicies, Character Removing/Swapping, String Iteration. 