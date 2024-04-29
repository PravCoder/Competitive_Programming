class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        // compute inital threeSum with first 3 elements
        int threeSum = nums[0] + nums[1] + nums[nums.size() -1];
        // sort the array
        sort(nums.begin(), nums.end());  
        // iterate from start to just before 2 elements, so we can access 3 elements each iteration
        for (int i=0; i<nums.size()-2; i++) {
            int left = i+1;  // left-pointer is 1 after cur-index
            int right = nums.size()-1;  // right-pointer is always last-index
            // while left-pointer and right-pointer have not crossed
            while (left < right) {
                // compute cur-sum using cur-index and left-right-pointers
                int curSum = nums[i] + nums[left] + nums[right];
                // if curSum is greater than target then decrement right to decrease the sum because it is a sorted array
                if (curSum > target) {
                    right -= 1;
                // if cur-sum is less than target increment left-pointer to increase sum because it is sorted array
                } else {
                    left += 1;
                }
                // compute cur-distance from curSum to target
                int curDistance = abs(curSum - target);
                // if cur-distance is less than distance from the old-threeSum and target, replace it. 
                if (curDistance < abs(threeSum - target)) {
                    threeSum = curSum; 
                }
            }

        }

        return threeSum; 
    }

};