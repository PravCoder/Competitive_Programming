
class MaxIncreaseToKeepCitySkyLine {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int increase = 0;
        int[][] og = grid.clone();  // store the original-input state of the grid

        // iterate the rows of the grid
        for (int i=0; i<grid.length; i++) {
            // iterate the cols of the current-row
            for (int j=0; j<grid[i].length; j++) {
                int maxInRow = getMaxInRow(og, i);  // get the max height of cur-row
                int maxInCol = getMaxInCol(og, j);  // get the max height in cur-col, passing in original

                System.out.println("b: "+og[i][j]);
                System.out.println("r: "+maxInRow);
                System.out.println("c: "+maxInCol);
                System.out.println("----");
                // compute the min between max heights
                int maxAllowed = Math.min(maxInRow, maxInCol);
                // compute amount we increasing cur-height by New - Old
                increase += maxAllowed - og[i][j];  
                // set the new height of cur-building-i-j
                grid[i][j] = maxAllowed;
            }
        }
        return increase;
    }

    
    public int getMaxInRow(int[][] grid, int row) {
        int max = -1;
        // iterate the column-indicies of that row
        for (int c=0; c<grid[row].length; c++) {
            // row-index is same column-index is icremented
            if (grid[row][c] > max) {
                max = grid[row][c];
            }
        }
        return max;
    }
    public int getMaxInCol(int[][] grid, int col) {
        int max = -1;
        // iterate the row-indicies of that column
        for (int r=0; r<grid.length; r++) {
            // row-index is incremented, col index is same
            if (grid[r][col] > max) {
                max = grid[r][col];
            }
        }
        return max;
    }
}

// 807. Max Increase to Keep City Skyline

// Note: each element inteer in 2d-arr is the height of the building. We can set hte height of any building to
// whatever we want. We want to increase the height of each building as much as we can without changing the
// city's skyline, we max we change the height of building in hte min of the max height in its row and max height 
// in its col. 

// Patterns: 2D-Array, Iterate Rows/Cols, 