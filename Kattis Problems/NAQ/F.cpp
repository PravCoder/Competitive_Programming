#include <iostream>
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <vector>
#include <iomanip> 
#include <utility>  // for std::pair
#include <tuple>  // for std::tuple
#include <cmath>
using namespace std;
/* 
Input:
x1, y1, x2, y2 - Foci points
a - Distance between foci points

Output:
Coordinates of tightest box around ellipse. 
lower-left-coordinates, upper-right-coordinates.


SOLUTION:
h,k = center
a = in ellipse equation is semi-major axis
b = in ellipse equation semi-minor axis. 

Top-right coordiantes:
intersection of following lines:
- tangent line of maximum-y-val point on ellipse
- tangent line of maximum-x-val point on ellipse

Lower-Left coordiantes:
intersection of following lines:
- tangent line of minimum-y-val point on ellipse
- tangent line of minimum-x-val point on ellipse



*/


// given one of the foci, center, semi-major-axis length
double find_semi_minor(double x1, double y1, double h, double k, double semi_major) {
    // TBD
    double b;
    double c = sqrt( pow(h-x1, 2) + pow(k-y1, 2) );
    b = sqrt( pow(semi_major, 2) - pow(c, 2));
    return b;

}

// given foci computes ellipse center
vector<double> find_center(int x1, int y1, int x2, int y2) {
    double xm = (x1 + x2) / 2;
    double ym = (y1 + y2) / 2;
    vector<double> out;
    out.push_back(xm);            
    out.push_back(ym);
    return out;
}

// given a point,a,b computes tangent line slope of that point on ellipse
double compute_tangent_line_slope(double x0, double y0, double h, double k, double semi_major, double semi_minor) {
    double numerator = -1 * pow(semi_minor, 2) * (x0 - h);
    double denominator = pow(semi_major, 2) * (y0 - k);
    if (denominator == 0) {  // if its a vertical tangent the slope will be infinity
        return -111;         // just a flag so its
    }
    double slope = numerator / denominator;
    return slope;
}

double compute_tangent_line_y_inter(double x0, double y0, double slope) {
    double y_inter = y0 - (slope * x0);
    return y_inter;
}

// given slope/y-inter of 2 lines computes their intersection point
vector<double> compute_intersection_point_of_lines(vector<double> line1, vector<double>line2) {
    // if both points are not vertical tangents
    double m1 = line1[0];
    double b1 = line1[1];
    double m2 = line2[0];
    double b2 = line2[1];
    double x_inter = (b2-b1) / (m1-m2);
    double y_inter = (m1*y_inter) + b1;
    vector<double> point;

    // line1 is vertical tangent
    if (line1.size() == 3) {
        y_inter = (line2[0] * line1[0]) + line2[1];
        x_inter = line1[1];  // x-intersection is equation to b-value or x= value of vertical tangent
        point.push_back(x_inter);
        point.push_back(y_inter);
        return point;
    }
    // line2 is vertical tangent
    else if (line2.size() == 3) {
        y_inter = (line1[0] * line2[0]) + line1[1];
        x_inter = line2[1];
        point.push_back(x_inter);
        point.push_back(y_inter);
        return point;
    } else {
        point.push_back(x_inter);
        point.push_back(y_inter);
        return point;
    }

}

int main() {
    // Input: -5 0 5 0 16
    // Ellipse: \frac{\left(x-\left(0\right)\right)^{2}}{\left(8\right)^{2}}+\frac{\left(y-\left(0\right)\right)^{2}}{\left(6.245\right)^{2}}=1
    int x1, y1, x2, y2, a;
    cin >> x1 >> y1 >> x2 >> y2 >> a;

    vector<double> center = find_center(x1, y1, x2, y2);
    double h = center[0];
    double k = center[1];

    double semi_major_axis = a/2; // semi-major = major-axis divided by 2
    double semi_minor_axis= find_semi_minor(x1, y1, h, k, semi_major_axis);

    // TBD: find optim points

    // ***FIND TOP-RIGHT INTERSECTION POINT***
    
    // // Maximum y-value point
    // double x_max_y_value = 0;
    // double y_max_y_value = 6.245;
    // // Maximum x-value point
    // double x_max_x_value = 8;
    // double y_max_x_value = 0;

    // Maximum y-value point
    double x_max_y_value = 35;
    double y_max_y_value = 67.0227;
    // Maximum x-value point
    double x_max_x_value = 70;
    double y_max_x_value = 45;

    // Maximum y-value point
    double m1 = compute_tangent_line_slope(x_max_y_value, y_max_y_value, h, k, semi_major_axis, semi_minor_axis);
    double b1 = compute_tangent_line_y_inter(x_max_y_value, y_max_y_value, m1);
    vector<double> max_y_value_line;
    if (m1 == -111) {   // if its vertical tangent, set slope to zero and set y-inter to its x-coordinate
        m1 = 0;
        b1 = x_max_y_value;
        max_y_value_line.push_back(m1);
        max_y_value_line.push_back(b1);
        max_y_value_line.push_back(-111);
    } else {
        max_y_value_line.push_back(m1);
        max_y_value_line.push_back(b1);
    }
    
    // Maximum x-value point
    double m2 = compute_tangent_line_slope(x_max_x_value, y_max_x_value, h, k, semi_major_axis, semi_minor_axis);
    double b2 = compute_tangent_line_y_inter(x_max_x_value, y_max_x_value, m2);
    vector<double> max_x_value_line;
    if (m2 == -111) { // if its vertical tangent, setp slope to zero and set y-inter to its x-coordinate
        m2 = 0;
        b2 = x_max_x_value;
        max_x_value_line.push_back(m2);
        max_x_value_line.push_back(b2);
        max_x_value_line.push_back(-111);
    } else {
        max_x_value_line.push_back(m2);
        max_x_value_line.push_back(b2);
    }
    vector<double> top_right_intersection_point = compute_intersection_point_of_lines(max_y_value_line, max_x_value_line);

    cout << "Center: " << h << "," << k << endl;
    cout << "Semi-major: " << semi_major_axis << endl;
    cout << "Semi-minor: " << semi_minor_axis << endl;

    cout << "TOP-RIGHT" << endl;
    cout << "Max-y-value-point tangent line: y = " << m1 << "x + " << b1 << endl;  // it might be 
    cout << "Max-x-value-point tangent line: y = " << m2 << "x + " << b2 << endl;
    cout << "Intersection: " << top_right_intersection_point[0] << ", " << top_right_intersection_point[1] << endl;


    // ***FIND BOTTOM-LEFT INTERSECTION***

    // Minimum y-value point
    // double x_min_y_value = 0;
    // double y_min_y_value = -6.245;
    // Minimum x-value point
    // double x_min_x_value = -8;
    // double y_min_x_value = 0;

    // Minimum y-value point
    double x_min_y_value = 35; 
    double y_min_y_value = 22.9773;
    // Minimum x-value point
    double x_min_x_value = 0;
    double y_min_x_value = 45;

    // Minimum y-value point
    m1 = compute_tangent_line_slope(x_min_y_value, y_min_y_value, h, k, semi_major_axis, semi_minor_axis);
    b1 = compute_tangent_line_y_inter(x_min_y_value, y_min_y_value, m1);
    vector<double> min_y_value_line;
    if (m1 == -111) {   // if its vertical tangent, set slope to zero and set y-inter to its x-coordinate
        m1 = 0;
        b1 = x_min_y_value;
        min_y_value_line.push_back(m1);
        min_y_value_line.push_back(b1);
        min_y_value_line.push_back(-111);
    } else {
        min_y_value_line.push_back(m1);
        min_y_value_line.push_back(b1);
    }
    
    // Minimum x-value point
    m2 = compute_tangent_line_slope(x_min_x_value, y_min_x_value, h, k, semi_major_axis, semi_minor_axis);
    b2 = compute_tangent_line_y_inter(x_min_x_value, y_min_x_value, m2);
    vector<double> min_x_value_line;
    if (m2 == -111) { // if its vertical tangent, setp slope to zero and set y-inter to its x-coordinate
        m2 = 0;
        b2 = x_min_x_value;
        min_x_value_line.push_back(m2);
        min_x_value_line.push_back(b2);
        min_x_value_line.push_back(-111);
    } else {
        min_x_value_line.push_back(m2);
        min_x_value_line.push_back(b2);
    }
    vector<double> bottom_left_intersection_point = compute_intersection_point_of_lines(min_y_value_line, min_x_value_line);


    cout << "BOTTOM-LEFT" << endl;
    cout << "Min-y-value-point tangent line: y = " << m1 << "x + " << b1 << endl;
    cout << "Min-x-value-point tangent line: y = " << m2 << "x + " << b2 << endl;
    cout << "Intersection: " << bottom_left_intersection_point[0] << ", " << bottom_left_intersection_point[1] << endl;
    


}