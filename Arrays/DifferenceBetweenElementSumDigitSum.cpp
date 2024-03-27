class Solution {
public:
    int differenceOfSum(vector<int>& nums) {
        int elementSum = 0;
        int digitSum = 0;

        for (int i=0; i<nums.size(); i++) {
            int cur = nums[i];  // extract current element
            string curStr  = std::to_string(cur);
            elementSum += nums[i];  // add to element sum

            for (int j=0; j<curStr.length(); j++) {
                int digit = curStr[j] - '0';
                cout << digit;
                digitSum += digit;
            }
            

        }

        return elementSum - digitSum;

    }
};