import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


// TIME LIMIT EXCEEDED SOLUTION
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

// PASSED SOLUTION
class FindingUsersActiveMins1 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        int[] output = new int[k]; 
        // { user-id: set(t,i,m,e) }
        HashMap<Integer,HashSet<Integer>> map =new HashMap<>();
        // iterate each log
        for (int[] log: logs) {
            int userID = log[0];  // get cur user and time
            int time = log[1];
            // if we havent seen this user, add them into hash with empty hashset
            if (map.containsKey(userID) == false) {
                map.put(userID, new HashSet<>());
            }
            // get the cur-user and add cur-time to their hashset, this runs
            // even when we have seen user with this ID
            map.get(userID).add(time);
        }
        // itertate user-id-key of hashmap
        for (int userID: map.keySet()) {
            // the unqiue mins is the size of their value-hashset
            int UAM = map.get(userID).size();
            // UAM-1 is the index in output, since j=UAM, j-1 is the index
            output[UAM-1] += 1;

        }
        return output;

        
    }

}

// NOTE: answer[j] is the number of users whose UAM equals j-index.
// hashset prevent duplicates
// 1817. Finding the Users Active Minutes
// Patterns: Hashmap
