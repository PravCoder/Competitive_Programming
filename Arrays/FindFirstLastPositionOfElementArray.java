class FindFirstLastPositionOfElementArray {
    public int[] searchRange(int[] nums, int target) {

        int[] output = new int[]{-1, -1}; // initalize to not found
        // iterate nums
        for (int i=0; i<nums.length; i++) {
            int cur = nums[i];  // get cur-num
            // if cur is equal to target and it is less than cur-start-pos OR
            // if cur is equal to target and start pos is negative-1
            // set the new start-pos-min to cur-index-i
            if ((cur == target && i < output[0]) || (cur == target && output[0]==-1)) {
                output[0] = i;
            }
            // if cur is equal to target and it is greater than cur-end-pos OR
            // if cur is equal to target and end pos is negative-1
            // set the new  end-pos-min to cur-index-i
            if ((cur == target && i > output[1]) || (cur == target && output[1]==-1)) {
                output[1] = i;
            }

        }
        // if any index is negative-1 and the other is not set it equal to other
        // because if there is 1-occurance 
        if (output[0] == -1) {
            output[0] = output[1];
        }
        if (output[1] == -1) {
            output[1] = output[0];
        }
        return output;
        
    }
}

// 34. Find First and Last Position of Element in Sorted Array

// NOTE: approach is to look at the firs tposition as the minimum index occurance of target and the 
// last position as the maximum index occurance of target. 

// Patterns: Array Iteration, Checking Index of Array, Target Element Finding