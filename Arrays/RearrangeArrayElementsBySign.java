import java.util.ArrayList;


// TIME LIMIT EXCEEDED SOLUTION
class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {

        ArrayList<Integer> positive = new ArrayList<Integer>();
        ArrayList<Integer> negative = new ArrayList<Integer>();

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                positive.add(nums[i]);
            }
            if (nums[i] < 0) {
                negative.add(nums[i]);
            }
        }

        int[] output = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i % 2 == 0) {
                output[i] = positive.get(0);
                positive.remove(0);
            }
            if (i % 2 != 0) {
                output[i] = negative.get(0);
                negative.remove(0);
            }
        }
        
        return output;
        
    }
}



// PASSED SOLUTION
class RearrangeArrayElementsBySign1 {
    public int[] rearrangeArray(int[] nums) {
        // stores positive elements in nums
        ArrayList<Integer> positive = new ArrayList<Integer>();
        // stores negative elements in nums
        ArrayList<Integer> negative = new ArrayList<Integer>();
        // iterate nums and seperate positive and negative nums
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                positive.add(nums[i]);
            }
            if (nums[i] < 0) {
                negative.add(nums[i]);
            }
        }
        // stores hte rearagned elements init to nums-size
        int[] output = new int[nums.length];
        int j = 0;  // negative-arr index
        int k = 0;  // positive-arr index
        // iterate nums-indicies
        for (int i=0; i<nums.length; i++) {
            output[i] = positive.get(k); // set cur-i to positive-num
            k += 1;                      // increment positive-indx
            i += 1;                      // increment i
            output[i] = negative.get(j); // set cur-i to negative-num
            j += 1;                      // increment j
        }
        
        return output;
        
    }
}
// 2149. Rearrange Array Elements by Sign