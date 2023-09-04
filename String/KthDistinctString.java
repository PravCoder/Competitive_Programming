import java.util.ArrayList;

public class KthDistinctString {

    public String kthDistinct(String[] arr, int k) {

        ArrayList<String> distinct = new ArrayList<String>();

        for (int i=0; i<arr.length; i++) {
            String curStr = arr[i];
            int count = 0;
            // iterate to find count of cur element
            for (int j=0; j<arr.length; j++) {
                if (i != j && curStr.equals(arr[j])) {
                    count += 1;
                }
            }

            if (count == 0) {
                distinct.add(curStr);
            }

        }

        if (distinct.size() < k) {
            return "";
        }

        return distinct.get(k-1);  // kth distinct element is k-1 for index


    }
    
}
