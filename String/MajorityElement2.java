import java.util.ArrayList;
import java.util.List;

class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> majNums = new ArrayList<Integer>();
        int requirement = Math.round(nums.length/3);

        for (int i=0; i<nums.length; i++) {
            int cur = nums[i];
            // if cur-element occurs at last n/3 times and has not been added in list
            if (getCount(nums, cur) > requirement && majNums.contains(cur) == false) {
                majNums.add(cur);
            }
        }
        return majNums;
        
    }
    public int getCount(int[] nums, int integer) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            int c = nums[i];
            if (c == integer) {
                count += 1;
            }
        }
        return count;
    }
}


// Patterns: Get Count of element, Element Exists.

// 229. Majority Element II