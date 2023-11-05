import java.util.ArrayList;

class FindingUsersActiveMins {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        int[] output = new int[k];  // store arr of length-k
        // iterate users and collect unique userIDs
        ArrayList<Integer> uniqueUsers = new ArrayList<Integer>();
        for (int[] log: logs){
            if (uniqueUsers.contains(log[0]) == false) {
                uniqueUsers.add(log[0]);
            }
        }
        
        // iterate output-indicies
        for (int i=0; i<output.length; i++) {
            int j = i+1;  // increment i to get j
            int numUsers = 0; 
            // iterate unique-user-id's'
            for (Integer userID: uniqueUsers) {
                // if cur-user UAM equals j increment numUsers
                if (getUserUAM(userID, logs) == j) {
                    numUsers += 1;
                }
            }
            output[i] = numUsers;  // replce output-index-cur-i with numUsers with UAM=j
        }
        return output;
    }

    public int getUserUAM(int userID, int[][] logs) {
        ArrayList<Integer> uniqueMins = new ArrayList<Integer>();
        // iterate logs
        for (int[] log: logs) {
            // ig cur-log is this user and we havent see this minuete add it. 
            if (log[0] == userID && uniqueMins.contains(log[1]) == false) {
                uniqueMins.add(log[1]);
            }
        }
        // return number of unqiue minutes. 
        return uniqueMins.size();
    }
}

// NOTE: answer[j] is the number of users whose UAM equals j-index.
// 1817. Finding the Users Active Minutes