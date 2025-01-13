// CODE CHEF
#include <bits/stdc++.h>
using namespace std;

int main() {
    int testcases;
    cin>>testcases;
    // for every testcase
    while(testcases--){
        int num_problems;  // get number of problem for cur-testcase
        cin>>num_problems;
        int problem_levels[num_problems]; // empty arr of size num-prob
        
        int cur; // stores the previous number
        string out = "Yes";
        for(int i=0; i<num_problems ;i++){
            cin>>problem_levels[i]; // read in next num
            // if its the first num just set it as cur
            if (i==0) {
                cur = problem_levels[0];
            // if its next num-> if the number we just read in is less than the previous number we stored its not ascending. 
            } else {
                if (problem_levels[i] < cur) {
                   out = "No";
                }
                cur = problem_levels[i]; // set the num we just read in as the new cur, previous num
            }
        }
        cout << out << "\n";
    }

}
// Reading in as we get input, instead of getting input and then iterating arr