#include <iostream>
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <vector>
#include <iomanip> 
using namespace std;

/* 

Problem:
-scott is riding up the y-axis
-starts at origin
-baricades are line segments given as their end points
-find how far scott can ride without hitting baricade

Input:
- first n is number of num_baricades
- then each line as x1 y1 x2 y2 endpoints of nth baricade.

Output:
- single number how far scott can ride before he hits obstacle.
- -1 if he hits no obstacle. 

order of baricades shouldnt matter in solution
    
*/

double does_baricade_hit_y_axis(int x1, int y1, int x2, int y2) { // finding y-intercept of those 2 endpoints
    // if it even intersects y-axis
    if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) { 
        double slope = static_cast<double>(y2 - y1) / (x2 - x1);
        double y_inter = y1 - (slope * x1);
        if (y_inter >= 0) {
            // cout << "y-inter: "<< y_inter << endl;
            return y_inter;
        }
    }
    return -1;
}

int main() {
    int num_baricades;
    cin >> num_baricades;
    
    // lowest baricade that hits y-axis
    // initalize to max y-value
    double lowest_baricade_y_inter = 100;     
    for (int i=0; i<num_baricades; i++) { // default -1 he keeps going forever
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        
        double y_inter = does_baricade_hit_y_axis(x1, y1, x2, y2);
        
        // if the cur-baricade y-inter is lower than the cur lowerest
        // baricade that hits y-axis, and it does hit y-axis
        if (y_inter != -1 && y_inter < lowest_baricade_y_inter) {
            lowest_baricade_y_inter = y_inter;  // never -1
        }
        
    }
    
    // if never found a baricade that hits y-axis then return -1
    // he keeps moving forever. 
    if (lowest_baricade_y_inter == 100) {
        cout <<-1;
        return 0;
    }
    
    cout << fixed << setprecision(16) << lowest_baricade_y_inter << endl;

    return 0;
}