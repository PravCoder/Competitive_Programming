// TIME LIMIT EXCEEDED
class Solution {
public:

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> output;
        if (strs.size() == 0) { 
            return output;
        }

        // iterate strings, and start creating groups
        for (int i = 0; i < strs.size(); ++i) { 
            output = addOrCreateNewGroup(output, strs[i]);
        }
        
        return output;
    }

    // adds a string to a group or creates a new group
    vector<vector<string>> addOrCreateNewGroup(vector<vector<string>> output, string base) {
        
        // if it fits in a group then add it to that group and return.
        // if it doesnt fit in the group, then create a new group with only it in it. return
        // iterate all groups in output
        bool foundAgroup = false;
        for (int i = 0; i < output.size(); ++i) { 
            // if given string is anagram in cur-group, add it to the cur-group
            if (isAnagram(base, output[i][0]) == true) {
                output[i].push_back(base);
                foundAgroup = true;
            }
        }
        if (foundAgroup == false) {
            vector<string> new_group;
            new_group.push_back(base);
            output.push_back(new_group);
        }
        return output;
    }

    bool static isAnagram(string base, string other) {
        // if they are sasme string they are anagram
        if (base == other) {
            return true;
        }
        // since empty string is not anagram of "b", it is not anagram if one of them is a empty return false
        if (base.empty() != other.empty()) {
            return false;
        }
        // if they are not same lengths they cannot be anagrams
        if (base.size() != other.size()) {
            return false;
        }

        // count freuencies of each char in first-word
        map<char, int> count1;
        for (char cur_char : base) {
            // if cur-char doesnt already exist then it init with key/val w 0, and adds 1, else just increments
            count1[cur_char] += 1;
        }

        // get counts for second word
        map<char, int> count2;
        for (char cur_char : other) {
            count2[cur_char] += 1;
        }

        // iterate every key-val pair in map, .first=key, .second=value
        for (const auto& pair : count1) {
            // if the counts of the char in both words are not equal then no anagrams
            if (count2[pair.first] != pair.second) {
                return false; 
            }
        }

        return true;
    }
};


// PASSED
class Solution {
public:

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        // each element is a group, in each group is that set of anagrams
        vector<vector<string>> output;
        // map where key is the base-sorted-anagram-string, and value is the group of all anagrams in strs
        unordered_map<string, vector<string>> anagram_groups;
        
        // iterate each string
        for (int i=0; i<strs.size(); i++) {
            string cur_str = strs[i];  
            string cur_sorted_str = strs[i];  // stores the sorted-base-key-string for map
            // sort the cur-string to use as a key in anagram-groups
            sort(cur_sorted_str.begin(), cur_sorted_str.end());  
            // if the sorted-base-string key doesnt exist in map, create a new key-val-pair and add cur-str to it. 
            // if the sorted-base-string key does exist in map, add the original string to that keys group
            anagram_groups[cur_sorted_str].push_back(cur_str); 
        }

        // iterate each key-value or base-string anagram-group pairs
        for (auto& pair : anagram_groups) {
            // get the value of each anagram-pair in map, and add it to result
            output.push_back(pair.second);
        }

        return output;
    }

};