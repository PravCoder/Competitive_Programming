class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        vector<int> answer;
        // iterate all prices
        for (int i=0; i<prices.size(); i++) {
            // init the cur-min-indx to a big max value
            int min_indx = prices.size()+1;
            // iterate all elements after cur-i
            for (int j=i+1; j<prices.size(); j++) {
                // if j is more than i and j-indx is less than cur-min-indx, replace it
                if (prices[j] <= prices[i] & j < min_indx) {
                    min_indx = j;
                    // because we just want the minimum indux where element j > ele i
                    break; 
                }    
            }
            // if the min-indx is still the big-max value we didnt find discount
            if (min_indx == prices.size()+1) {
                answer.push_back(prices[i]);
            // compute discount which is min-indx
            } else {
                int cur_discount = prices[i] - prices[min_indx];
                answer.push_back(cur_discount);
            }
            
        }
        return answer;
    }

};