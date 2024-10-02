// KATTIS

#include <iostream>
#include <string>
#include <vector>
using namespace std;
#include <iostream>
#include <sstream>
#include <vector>

int main() {
    // string input = "3-10";   // static input for testing
    string input;  
    cin >> input;
    
    stringstream ss(input);  // creating stringstream passing input as value
    string segment;  // temporary
    vector<string> segments; 
    
    // reads characters from teh stringstream-ss until ti finds ;, stores the part before ;
    // in temporary variable segment
    while (getline(ss, segment, ';')) {
        segments.push_back(segment);
    }
    
    // PRINT SEGMENTS OF INPUT
    // cout << "all segments" << endl;
    // for (const string& s : segments) {
    //     std::cout << s << endl;
    // }
    
    int num_problems = 0;
    
    for (int i=0; i<segments.size(); i++) {
        string cur_seg = segments[i];
        
        // if the segment is like 13, 1, 10 single number then just add it
        if (cur_seg.find('-') == string::npos) {
            num_problems += 1;  // single problem segment so add one
            
        }
        // if the segment is has a dash so have to count multiple questions 
        else if (cur_seg.find('-') != string::npos) {
            stringstream aa(cur_seg);  // creating stringstream passing in current segment as value
            string before; // stores number before the ; in cur-seg
            string after;  // stores number after the ; in cur-seg
            // cout << "cur-segment: "<<cur_seg << endl;
            getline(aa, before, '-');   // gets everything after dash, in stringstream aa which has value of cur-segment
            getline(aa, after);         // gets everything before dash
            // cout << "before: "<<before << endl;
            // cout << "after: "<<after << endl;
            int lower = stoi(before);
            int upper = stoi(after);
            for (int j=lower; j <= upper; j++) {
                num_problems += 1;
            }
        }
    }
    cout << num_problems;
    return 0;
}


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
    // PRINT SEGMENT
    // int i = 0;
    // for (int i=0; i<segments.size(); i++) {
    //     cout << segments[i] << endl;
    // }
    
    int i = 0;
    for (int i=0; i<segments.size(); i++) {
        string cur_seg = segments[i];
        // cout << "Cur-segment: " << cur_seg << endl;
        bool hyphenExists = cur_seg.find('-') != std::string::npos;
        // cout << hyphenExists;
        if (hyphenExists == false) {
            // cout << "add 1" << endl;
            num_problems += 1;
        }
        else if (hyphenExists == true) {
            int hyphen_indx = cur_seg.find("-");
            string before_hyphen = cur_seg.substr(0, hyphen_indx);
            string after_hyphen = cur_seg.substr(hyphen_indx+1, cur_seg.length());
            // cout << "before: "<<before_hyphen << endl;
            // cout << "after: "<<after_hyphen << endl;
            int after = stoi(after_hyphen);
            int before = stoi(before_hyphen);
            int problems_in_range = (after - before)+1;
            // cout << "add " << problems_in_range << endl;
            num_problems += problems_in_range;
        }
    }

    /*
    for every segment
        if segment has hyphen:
            thing_before_hyphen = 
            thing_after_hyphen = 
            num_problems += abs()
        if segment doesnt have hyphen:
            num_problems ++
    */
    
    cout << num_problems;
    return num_problems;
}