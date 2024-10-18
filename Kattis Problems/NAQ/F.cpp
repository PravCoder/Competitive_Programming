#include <iostream>
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <vector>
#include <iomanip> 
#include <utility>  // for std::pair
#include <tuple>  // for std::tuple
using namespace std;
/* 
Input:
x1, y1, x2, y2 - Foci points
a - Distance between foci points

Output:
Coordinates of tightest box around ellipse. 
lower-left-coordinates, upper-right-coordinates.


SOLUTION:

Top-right coordiantes:
intersection of lines:
- tangent line of maximum-y-val point on ellipse
- tangent line of maximum-x-val point on ellipse

Lower-Left coordiantes:
- tangent line of minimum-y-val point on ellipse
- tangent line of minimum-x-val point on ellipse



*/

vector<double> find_center(int x1, int y1, int x2, int y2) {
    double xm = (x1 + x2) / 2;
    double ym = (y1 + y2) / 2;
    vector<double> out;
    out.push_back(xm);            
    out.push_back(ym);
    return out;
}

int main() {
    int x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;

    vector<double> center = find_center(x1, y1, x2, y2);
    double h = center[0];
    double k = center[1];

    cout << h << " " << k;


}