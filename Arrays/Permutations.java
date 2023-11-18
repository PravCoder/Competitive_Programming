import java.util.ArrayList;
import java.util.List;

class Permutations {
    
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();  // output
        // call backtracking-method
        backtrack(result, new ArrayList<>(), nums);  // passing output, empty-cur-permutation and input-nums

        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums) {
        // if size of cur-permutation is equal to length of input then add cur-permutation to output-arr
        // because cur-permutation is complete
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // iterate input-nums
        for (int number: nums) {
            // if the cur-permutation contains the cur-element, we cannot add it because nums is distinct integers 
            if (temp.contains(number) == true) {
                continue;
            }
            // else add cur-num to cur-permutation 
            temp.add(number);
            // recursive call passing in otput, cur-permutation, input-nums
            backtrack(result, temp, nums);
            // remove the last element in cur-permutation
            temp.remove(temp.size()-1);
        }
    }
}

// Note: put a decision tree with the root level as all of the inital elements and visualize it
// Patterns: Backtracking, Recursion

// The removal of the last element (tempList.remove(tempList.size() - 1)) is a crucial step in the backtracking process. Let me explain why this step is necessary.

// // In the backtracking algorithm, when exploring different branches of the recursion tree, you add elements to the current state (tempList) to try out different possibilities. After exploring a branch (i.e., after making the recursive call), you need to undo the changes made to the current state to backtrack to the previous state and explore other possibilities.

// // 46. Permutations