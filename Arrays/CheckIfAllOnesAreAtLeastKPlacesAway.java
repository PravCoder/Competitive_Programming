
class CheckIfAllOnesAreAtLeastKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {

        int prev = -1;  // stores pointer to previous 1-element, init to -1 to identify first 1
        int zeros = 0;  // stores number of zeros between previous-1 and cur-i-1
        // iterate nums indicies
        for (int i=0; i<nums.length; i++) {
            // if i-num is 1 and prev is -1 then its first element, so set prev to i 
            if (nums[i] == 1 && prev == -1) {
                prev = i;
                zeros = 0;
            }
            // if prev is not -1 its not first element-1, so if cur-i is 1
            else if (nums[i] == 1) {
                // and number of zeros between previous-1 and cur-i-1 is less than k return false
                if (zeros < k) {
                    return false;
                }
                // set previous-1-index to 1 because its the latest 1 we gound
                prev = i;
                // reset zeros back to 0, because its the number of zeros between cur-i-1 and next 1
                zeros = 0;  
            }
            // if cur-i is 0 increment zero count
            else if (nums[i] == 0) {
                zeros += 1;
            }
        }

        return true;
        
    }
}

// 1437. Check If All 1's Are at Least Length K Places Away
// Patterns: Array Single Pointer, Occurances Between Elements, Is Array in Correct State.