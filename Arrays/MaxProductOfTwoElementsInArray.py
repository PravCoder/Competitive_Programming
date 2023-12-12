class MaxProductOfTwoElementsinArray:
    def maxProduct(self, nums):
        
        # initalize maximum computed value to negative infinity
        max_val = float("-inf") 
        # iterate nums
        for i in range(len(nums)):
            # for each iteration iterate nums again to find pair
            for j in range(len(nums)):
                # if current pair of indicies are not equal
                if i != j:
                    # compute their value
                    cur_val = (nums[i]-1)*(nums[j]-1)
                    # see if cur-val is greater than the max-value
                    max_val = max(max_val, cur_val)

        # after iteration and replacing max-val return it
        return max_val



# 1464. Maximum Product of Two Elements in an Array