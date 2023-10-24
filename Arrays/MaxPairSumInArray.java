
class MaxPairSumInArray {
    public int maxSum(int[] nums) {

        int sum = -1;  // init to -1 in case no pair of nums as same max digit
        // iterate indicies of num-arr
        for (int i=0; i<nums.length; i++) {
            int n1 = nums[i];
            // iterate from i to end of array
            for (int j=i+1; j<nums.length; j++) {
                int n2 = nums[j];
                // if num of pair is greater than sum and their max digits are same
                if (n1+n2 > sum && getMaxDigit(n1) == getMaxDigit(n2)) {
                    // update sum
                    sum = n1+n2;
                }
            }
        }
        return sum;
        
    }

    // converts given integer into string iterates characters and find largest 
    // digit-char and returns it as int
    public int getMaxDigit(int n) {
        String nStr = Integer.toString(n);
        int maxDigit = 0;
        for (int i=0; i<nStr.length(); i++) {
            if (Character.getNumericValue(nStr.charAt(i)) > maxDigit) {
                maxDigit = Character.getNumericValue(nStr.charAt(i));
            }
        }
        return maxDigit;
    }
}

// 2815. Max Pair Sum in an Array
// Patterns: Array Pair Iteration, Maximum of 2 Conditions. 