class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        // srotes coordinates of robot
        int x = 0;
        int y = 0;
        // iterate through moves string char by char
        for (int i=0; i <moves.length(); i++) {
            char move = moves.charAt(i); // get cur-char at index
            // check each move and update coordinates
            if (move == 'U') {
                y += 1;
            }
            if (move == 'D') {
                y -= 1;
            }
            if (move == 'L') {
                x -= 1;
            }
            if (move == 'R') {
                x += 1;
            }
        }
        // after all moves if cooridantes are at origin return true
        if (x == 0 && y == 0) {
            return true;
        } else {
            return false;
        }
        
    }
}