

class CheckOnesSegment {
    public boolean checkOnesSegment(String s) {
        int oneSegments = 0;  // stores number of one-segments

        int i = 0;  // initalize pointer to 0
        // while i is less than s--string-length
        while (i < s.length()) {
            // if cur-char is 1
            if (s.charAt(i) == '1') {
                int count = 0;
                // iterate while we havent reached end and i-char is 1, increment i-indx and count of ones
                // in current segment
                while (i < s.length() && s.charAt(i) == '1') {
                    count++;
                    i++;
                }
                // if number of ones in cur-segment is not zero, increment number of segments
                if (count >= 1) {
                    oneSegments++;
                }
            // if i is not 0 still increment it, but without 2nd while loop of checking fro segment
            } else {
                i++;
            }
        }

        // Handle the case where there is a single segment of ones at the start or end
        if (oneSegments == 0) {
            return false;
        }
        if (oneSegments == 1 && (s.charAt(0) == '1' || s.charAt(s.length() - 1) == '1')) {
            return true;
        }
        return oneSegments <= 1;
    }
}



// 1784. Check if Binary String Has at Most One Segment of Ones
// Patterns: String Iteration, Counting Elements

// FAILED SOLUTION
// class Solution {
//     public boolean checkOnesSegment(String s) {

//         int oneSegments = 0;

//         int i =0;
//         while (i<s.length()-1) {
//             if (s.charAt(i) == '1') {
//                 int count = 1;
//                 int j = i+1;
//                 while (j <s.length()-1 && s.charAt(j) == '1') {
//                     count += 1;
//                     j += 1;
//                 }
//                 if (count > 1) {
//                     oneSegments += 1;
//                     i += count-1;
//                 }
//             }
//             i += 1;
//         }
        
//         System.out.println(oneSegments);
//         if (oneSegments > 1 || oneSegments == 0) {
//             return false;
//         }
//         return true;
        
//     }
// }
