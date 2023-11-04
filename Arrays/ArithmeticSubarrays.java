import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> output = new ArrayList<>();  
        // iterate number of sub-arrs
        for (int i=0; i<l.length; i++) {
            // stores sub-arr
            ArrayList<Integer> arr = new ArrayList<Integer>();
            // iterate frmo left-indx to right-indx inclusive, and add nums-element
            for (int j=l[i]; j<=r[i]; j++) {
                arr.add(nums[j]);
            }

            arr.sort(Comparator.naturalOrder()); // for some reason sort
            output.add(isArithmetic(arr));      
        }
        return output;
        
    }

    public boolean isArithmetic(ArrayList<Integer> arr) {
        int diff = -1; 
        // iterate frmo 1 to end of arr
        for (int i=1; i<arr.size(); i++) {
            if (diff == -1) { // if its first pair compute difference
                diff = Math.abs(arr.get(i)-arr.get(i-1));
            }
            // if its not first pair compute cur difference and compare with previous difference
            else if (diff != -1) {
                int curDiff = Math.abs(arr.get(i)-arr.get(i-1));
                if (curDiff != diff) {
                    return false;
                }
            }
        }
        return true;
    }
}
// NOTE: can sub-arr be rearranged to be arithmatic?
// nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
// query-0: [4,6,5] -> false
// query-1: [4,6,5,9] -> true 2
// query-2: [5,9,3,7] -> false

// 1630. Arithmetic Subarrays
