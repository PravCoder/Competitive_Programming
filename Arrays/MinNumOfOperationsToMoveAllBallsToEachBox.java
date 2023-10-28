
class MinNumOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        // init array with length boxes-string, each element stores the number
        // of operations to move all the ones into that box-i
        int[] answer = new int[boxes.length()];

        // iterate the indicies of boxes
        for (int i=0; i<boxes.length(); i++) {
            int curOperations = 0;  // number of operations to move all balls in box-i
            // iterate boxes again to locate all the balls
            for (int j=0; j<boxes.length(); j++) {
                // if we are not looking at same box and the box as a ball in it
                if (i!=j && boxes.charAt(j) == '1') {
                    // the distance between the box and the cur-ball is the number of operations
                    // we will have to conduct to move that ball into that box. 
                    curOperations += Math.abs(j-i);
                }
            }
            // set answer-box-i equal to number of operations
            answer[i] = curOperations;
        }
        return answer;
        
    }
}

// boxes = "001011"
// i=5, answer[5] = 4
// answer[5] += (2-5=3)
// answer[5] += (4-5=1)
// answer[5] = 4

// 1769. Minimum Number of Operations to Move All Balls to Each Box

// Patterns: String Iteration Array Output, Minimum Operations, Moving Element to New Location.