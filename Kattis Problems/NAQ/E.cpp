#include <iostream>
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <vector>
#include <iomanip> 
#include <unordered_map>
#include <algorithm>
using namespace std;

/* 
KATTIS
Problem:
*/

double compute_percentage(int freq, int pop) {
    double percent = (static_cast<double>(freq) / pop) * 100; // to prevent int division
    return percent;
}


int main() {
    int n;
    cin >> n;
    
    unordered_map<int, int> counts;
    for (int i=0; i<n*10; i++) { 
        int a, b, c, d, e;
        cin >> a >> b >> c >> d >> e;
        int arr[] = {a, b, c, d, e};
        
        for (int i = 0; i < 5; ++i) {
            int cur = arr[i];
            // if number exists increment number of times we've seen it
            if (counts.find(cur) != counts.end()) {
                counts[cur] += 1;
            // if number doesn't exists add it to map
            }  else {
                counts[cur] = 1;
            } 
        }
    }
    // print map
    // for (const auto& pair : counts) {
    //     cout << "Key: " << pair.first << ", Value: " << pair.second << endl;
    // }
    

    // compute percentages of each key
    vector<int> invalid_nums;
    for (const auto& item : counts) { 
        double cur_percent = compute_percentage(item.second, n*10);
        // cout << "Key: " << item.first << ", perce: " << cur_percent << endl;
        if (cur_percent > 20) {
            invalid_nums.push_back(item.first);
        }
    }
    
    // Output
    if (invalid_nums.empty() == true) { 
        cout << -1;
    }
    
    // sort vector
    sort(invalid_nums.begin(), invalid_nums.end());
    
    for (int j=0; j<invalid_nums.size(); j++) {
        if (j != invalid_nums.size()-1) {
            cout << invalid_nums[j] << " ";
        } else {
            cout << invalid_nums[j];
        }
        
    }
    
    return 0;
}