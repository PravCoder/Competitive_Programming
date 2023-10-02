import java.util.ArrayList;
import java.util.List;

class PositionLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> output = new ArrayList<>();
        int i=0;
        int j=1;

        while (i<s.length()) {
            while (j<s.length() && s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
            if (Math.abs(j-i) >= 3) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j-1);
                output.add(temp);
            }
            i=j;
        }
        return output;
    }
}

// 830. Positions of Large Groups