import java.util.ArrayList;

class Solution {
    public boolean areNumbersAscending(String s) {
        // stores integer in s-string
        ArrayList<Integer> nums = new ArrayList<Integer>();

        String[] words = s.split(" "); // split into string-array by space
        // itearte each word
        for (String word: words) {
            // if it is a integer add it to nums
            try{
                nums.add(Integer.valueOf(word));
            } catch (NumberFormatException e) {
                System.out.println("Not integer");
            }
        }

        // iterate nums and check if each element is strictly increasing
        for (int i=0; i<nums.size(); i++) {
            for (int j=i+1; j<nums.size(); j++) {
                if (nums.get(i) >= nums.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}