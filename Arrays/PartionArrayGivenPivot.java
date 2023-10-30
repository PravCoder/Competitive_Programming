import java.util.ArrayList;


class PartionArrayGivenPivot {
    
    public int[] pivotArray(int[] nums, int pivot) {

        // stores elements less, greater, equal to pivot
        ArrayList<Integer> less = new ArrayList<Integer>();
        ArrayList<Integer> greater = new ArrayList<Integer>();
        ArrayList<Integer> equaly = new ArrayList<Integer>();
        // add each element to respective list
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < pivot) {
                less.add(nums[i]);
            }
            if (nums[i] > pivot) {
                greater.add(nums[i]);
            }
            if (nums[i] == pivot) {
                equaly.add(nums[i]);
            }
        }
        // combine all 3 lists less + equal + greater
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (Integer a: less) {
            output.add(a);
        }
        for (Integer a: equaly) {
            output.add(a);
        }
        for (Integer a: greater) {
            output.add(a);
        }
        // convert array list to normal array 
        int[] z = new int[output.size()];
        for (int i=0; i<output.size(); i++) {
            z[i] = output.get(i);
        }
        return z;
        
    }
}
// Patterns: Array List Normal Array, Compare Elements to Target Element.
// 2161. Partition Array According to Given Pivot

