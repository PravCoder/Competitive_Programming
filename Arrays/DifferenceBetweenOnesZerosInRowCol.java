

// TIME LIMIT EXCEED SOLUTION
class DifferenceBetweenOnesZerosInRowCol {
    public int[][] onesMinusZeros(int[][] grid) {
        // create empty list tof same dimensions
        int[][] diff = new int[grid.length][grid[0].length];
        // iterate row-indicies
        for (int i=0; i<grid.length; i++) {
            // itearte col-indicies
            for (int j=0; j<grid[i].length; j++) {
                int onesRow = 0;
                int onesCol = 0;
                int zeroRow = 0;
                int zeroCol = 0;
                // iterate row ->increment column-indx keep row-indx constant
                for (int c=0; c<grid[i].length; c++) {
                    if (grid[i][c] == 1) {
                        onesRow += 1;
                    }
                    if (grid[i][c] == 0) {
                        zeroRow += 1;
                    }
                }
                // iterate col ->increment row-indx keep col-indx constant
                for (int r=0; r<grid.length; r++) {
                    if (grid[r][j] == 1) {
                        onesCol += 1;
                    }
                    if (grid[r][j] == 0) {
                        zeroCol += 1;
                    }
                }
                // System.out.println(onesRow +" + "+onesCol+" - "+zeroRow+" - "+zeroCol + " = "+(onesRow+onesCol - zeroRow-zeroCol));
                // compute difference and replace with current cell (i,j)
                diff[i][j] = onesRow+onesCol - zeroRow-zeroCol;
            }

        }
        return diff;
        
    }
}
// 2482. Difference Between Ones and Zeros in Row and Column