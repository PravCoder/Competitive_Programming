#include <iostream>
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <vector>
#include <iomanip> 
using namespace std;

/* 
KATTIS


Problem B
Bikes and Barricades
Scott wants to ride his bike along a straight road. But the road has some barricades! Scott will ride his bike up to the first barricade and stop.

Model Scott’s straight road as the positive 
 axis, with Scott starting at the origin. The barricades are line segments, specified by their endpoints. Determine how far Scott can ride, or if his path is completely unobstructed.

Input
The first line of input contains a single integer 
 (
), which is the number of barricades.

Each of the next 
 lines contains four integers 
, 
, 
 and 
 (
, 
, 
), representing a barricade that runs from 
 to 
. It is guaranteed that no barricade will run through the origin.

Output
Output a single real number, which is how far Scott can ride before he hits the closest barricade, or 
 if no barricades get in Scott’s way. This output will be considered correct if it is within an absolute or relative error of 
.

Sample Input 1	
2
-10 7 5 19
-1 -1 8 21

Sample Output 1: 1.4444444444444446

Sample Input 2	Sample Output 2
2
4 -6 -12 -1
3 5 8 8

Sample Output 2-1.0
------------------------------------
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

double does_baricade_hit_y_axis(int x1, int y1, int x2, int y2) { // finding y-intercept of those 2 endpointsp÷
    // if it even intersects y-axis, is there a sing-change in x-values goes form pos to neg, then compute y-inter, else return -1 it doesn't
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