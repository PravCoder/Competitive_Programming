import java.util.ArrayList;

class MinimumIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {

        int leastIndexSum = Integer.MAX_VALUE;
        ArrayList<String> common = new ArrayList<String>();

        // find least index sum
        for (int i=0; i<list1.length; i++) {
            String cur = list1[i];
            int j = this.exists(cur, list2);
            if (j != -999 && (i+j) < leastIndexSum) {
                leastIndexSum = i+j;
            }
        }
        // iterate again to find all common strings that have lest-index-sum
        for (int i=0; i<list1.length; i++) {
            String cur = list1[i];
            int j = this.exists(cur, list2);
            if (j != -999 && (i+j) == leastIndexSum) {
                common.add(cur);
            }
        }
        // convert to output data-type
        String[] output = new String[common.size()];
        for (int i=0; i<common.size(); i++) {
            output[i] = common.get(i);
        }
        return output;
    }

    // returns if string exists in array
    public int exists(String word, String[] words) {
        for (int i=0; i<words.length; i++) {
            String w = words[i];
            if (w.equals(word) == true) {
                return i;
            }
        }
        return -999;
    }
}
// Sad: 1
// Happy: 0-1 = -1;

// 599. Minimum Index Sum of Two Lists
