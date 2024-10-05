#include <iostream>
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

/* 
KATTIS
n=number of candidate problems

just a even/odd problem
*/



int main() {
    int n;
    cin >> n;
        
    int num_excluded = 0;
    for (int i=0; i<n; i++) {
        int cur_prob_rating;
        cin >> cur_prob_rating;
        
        if (cur_prob_rating %2 != 0) {
            num_excluded += 1;
        }
        
    }
    
    cout << num_excluded;
    return 0;
}