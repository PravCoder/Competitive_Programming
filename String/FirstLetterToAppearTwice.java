import java.util.ArrayList;
import java.util.Collections;

// 1st SOLUTION
class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {

        ArrayList<Integer> duplicateIndices = new ArrayList<Integer>();
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            for (int j=i+1; j<s.length(); j++) {
                char possible = s.charAt(j);
                if (cur == possible) {
                    duplicateIndices.add(j);
                }
            }
        }

        return s.charAt(Collections.min(duplicateIndices));

    }
}

// 2nd SOLUTION: NOT STORING ALL DUPLICATE INDICIES
/* 
class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {

        int minDupIndex = s.length()-1;
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            for (int j=i+1; j<s.length(); j++) {
                char possible = s.charAt(j);
                if (cur == possible && j < minDupIndex) {
                    minDupIndex = j;
                }
            }
        }

        return s.charAt(minDupIndex);

    }
}
*/

// 3rd SOLUTION: 
/* 
class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {

        int minDupIndex = s.length()-1;
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            for (int j=i+1; j<s.length(); j++) {
                char possible = s.charAt(j);
                // no point in iterating if we already passed
                // the current minIndex
                if (j > minDupIndex) {
                    break;
                }
                if (cur == possible && j < minDupIndex) {
                    minDupIndex = j;
                }
            }
        }

        return s.charAt(minDupIndex);

    }
}
*/

// 4th SOLUTION:
/* 
class Solution {
    public char repeatedCharacter(String s) {

        HashSet<Character> set = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            // if cur-char already exists we gound its duplicate
            if (set.contains(s.charAt(i))) {
                return s.charAt(i);
            }
            // else add it into the set
            set.add(s.charAt(i));
        }
        return 'a';

    }
}

// NOTE: set doesn't allow duplicate values
*/