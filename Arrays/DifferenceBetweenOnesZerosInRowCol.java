

// TIME LIMIT EXCEED SOLUTION

import java.util.HashMap;

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

class DifferenceBetweenOnesZerosInRowCol2 {
    public int[][] onesMinusZeros(int[][] grid) {
        // {col-indx: number of ones in col}
        HashMap<Integer, Integer> colOnes = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> rowOnes = new HashMap<Integer, Integer>();
        // {row-indx: number of zeros in row}
        HashMap<Integer, Integer> colZero = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> rowZero = new HashMap<Integer, Integer>();
        // iterate rows
        for (int r=0; r<grid.length; r++) {
            rowOnes.put(r, 0);  // initalize in map
            rowZero.put(r, 0);
            // iterate column to loop through cur-row
            for (int c=0; c<grid[r].length; c++) {
                // keep row-indx constant and c-iterating
                if (grid[r][c] == 1) {
                    rowOnes.put(r, rowOnes.get(r)+1);
                }
                if (grid[r][c] == 0) {
                    rowZero.put(r, rowZero.get(r)+1);
                }
            }
        }
        // iterate  cols
        for (int c=0; c<grid[0].length; c++) {
            colOnes.put(c, 0);  // init col-indx counts
            colZero.put(c, 0);
            // iterate col-indx constant for cur-col-indx and iterate row-indx
            for (int r=0; r<grid.length; r++) {
                // update counts of 1/0's for cur-col
                if (grid[r][c] == 1) {
                    colOnes.put(c, colOnes.get(c)+1);
                }
                if (grid[r][c] == 0) {
                    colZero.put(c, colZero.get(c)+1);
                }
            }
        }
        // compute different formula for every cell using maps and their indicies
        int[][] diff = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                diff[i][j] = rowOnes.get(i)+colOnes.get(j) -rowZero.get(i)-colZero.get(j);
            }
        }
        
        return diff;
        
    }
}

// 2482. Difference Between Ones and Zeros in Row and Column Medium

// 2482. Difference Between Ones and Zeros in Row and Column