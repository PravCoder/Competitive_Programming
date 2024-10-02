#include <iostream>
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

int main() {
    string input;
    cin >> input;
    
    stringstream ss(input); 
    string segment;  
    vector<string> segments; 

    while (getline(ss, segment, ';')){
        segments.push_back(segment);
    }

    int num_problems = 0;

    for (int i=0; i<segments; i++) {
        std::cout << segments[i];
    }

    /*
    for every segment
        if segment has hyphen:
            thing_before_hyphen = 
            thing_after_hyphen = 
            num_problems += abs()
        if segment doesnt have hyphen:
            num_problems += 1

        
    */

    return num_problems;
}