import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GroupPeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // 2D-array
        List<List<Integer>> output = new ArrayList<>();
        // dictionary stores {group-size: number of people that belong to a group with that size}
        HashMap<Integer,Integer> unqiueGroupSizes = new HashMap<Integer,Integer>();
        // iterate group-sizes-indicies
        for (int i=0; i<groupSizes.length; i++) {
            // if the cur-group-size doesnt exist in hashmpa add it and init tis count to 1
            if (unqiueGroupSizes.keySet().contains(groupSizes[i]) == false) {
                unqiueGroupSizes.put(groupSizes[i], 1);
            }
            // if the cur-group-size does exist hashmap increment its count
            else if (unqiueGroupSizes.keySet().contains(groupSizes[i]) == true) {
                unqiueGroupSizes.put(groupSizes[i], unqiueGroupSizes.get(groupSizes[i]) + 1);
            }
        }

        // there maybe multiple gorups with the same size, so thsi soters integers for all the groups sizes
        // in output
        ArrayList<Integer> requiredGroupSizes = new ArrayList<Integer>();
        // iterate the unique-group-sizes
        for (int key: unqiueGroupSizes.keySet()) {
            // get the total number of groups of that size key
            int numGroups = unqiueGroupSizes.get(key)/key;
            System.out.println(key +", "+numGroups);
            // iterate number of groups and that groups-size to required-group-sizes
            for (int i=0; i<numGroups; i++) {
                requiredGroupSizes.add(key);
            }
            
        }

        // stores indicies-people that have been added to a group to prevent duplicates
        ArrayList<Integer> addedIndicies = new ArrayList<Integer>();
        // iterate required groups-zies including duplicate group-sizes
        for (int gs: requiredGroupSizes) {
            List<Integer> group = new ArrayList<>();  // stores group with current-size
            // iterate the input-group-sizes
            for (int i=0; i<groupSizes.length; i++) {
                // if the i-th person belongs to the current group size
                // and there is space in that group, and the i-th person has not already been added
                if (groupSizes[i] == gs && group.size() < gs && addedIndicies.contains(i) == false) {
                    group.add(i); // add them to the current group and to added indicies
                    addedIndicies.add(i);
                }
            }
            output.add(group);  // finally add theat group to the output
        }
        return output;
    }
}

// 1282. Group the People Given the Group Size They Belong To
// Pattern: 2D Array, Hasmap Count of Elements, Keep track of Computated Elements.

// Derive output by yourself to understand problem
// input: [2,1,3,3,3,2]
// output: [[1], [0,5], [2,3,4]]

// {group-size: number of people with that size}, {3:6} 6/3 = 2, need 2 groups of size 3

// REVIST