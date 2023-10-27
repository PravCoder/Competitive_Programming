
class QueriesNumberofpointsInsideCircle {
    public int[] countPoints(int[][] points, int[][] queries) {

        int[] output = new int[queries.length];   // each element stores the number of points in that circle
        // iterate each circle
        for (int i=0; i<queries.length; i++) {
            int[] circle = queries[i];  // get circle
            int count = 0;  // number of points in that circle
            // iterate all points
            for (int j=0; j<points.length; j++) {
                int[] curPoint = points[j];  // get point
                // if its in the current circle, incremnet count
                if (isInsideCircle(circle[0], circle[1], circle[2], curPoint[0], curPoint[1])) {
                    count += 1;
                }
            }
            // add it to answer for that circle
            output[i] = count;
        }   
        return output;
    }

    // given circle-center point, circle radius, and point we are trying to see if its in circle
    // compute distance between circle center nad point see if that is less than or equal to radius of circle. 
    public boolean isInsideCircle(int circleX, int circleY, int radius, int pointX, int pointY) {
        double dis = Math.sqrt(Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2));
        return dis <= radius;

    }
}


// 1828. Queries on Number of Points Inside a Circle
// Patterns: 2D-Array, Array Iteration, Math Coordinates. 