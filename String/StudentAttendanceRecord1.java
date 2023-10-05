
class StudentAttendanceRecord1 {
    public boolean checkRecord(String s) {

        int numAbsent = 0; // total number abscences
        int numLate = 0;  // number of current consectutive lates

        // iterate string-s characters
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);  // get current character
            // if cur is absent increment absent count and reset late-count
            // because we found a break in the consecutive lates
            if (cur == 'A') {
                numAbsent += 1;
                numLate = 0;
            }
            // of cur is present we found abreak in consecutive lates so reset numLate
            if (cur == 'P') {
                numLate = 0;
            }
            // if cur is late increment late
            if (cur == 'L') {
                numLate += 1;
            }
            // after each iteration if 
            if (numAbsent >= 2 || numLate >= 3) {
                return false;
            }
        }
        return true;
        
    }
}

// 551. Student Attendance Record I
