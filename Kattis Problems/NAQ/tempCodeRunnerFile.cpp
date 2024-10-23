
// vector<double> find_optimal_points() {
//     vector<double> output; 
//     // Maximum y-value point
//     double x_max_y_value = 0;
//     double y_max_y_value = 6.245;
//     // Maximum x-value point
//     double x_max_x_value = 8;
//     double y_max_x_value = 0;

//     double min_x_value;

//     const double pi = 3.14159265358979323846;
//     const double step = 0.01; // step size for theta
//     for (double theta = 0; theta < 2 * pi; theta += step) {
//         double x = h + a * cos(theta);
//         double y = k + b * sin(theta);

//         if (x > x_max_x_value) {
//             x_max_x_value = x;
//             y_max
//         }

//         cout << "Point on ellipse: (" << x << ", " << y << ")" << endl;
//     }
// }