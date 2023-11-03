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
// 2149. Rearrange Array Elements by Sign
