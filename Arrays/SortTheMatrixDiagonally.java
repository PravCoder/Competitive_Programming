class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        // iterating first row
        // row is constant 0, iterating diagonals that start from first row
        // then iterate column indicies
        for (int col=0; col<n; col+=1) {
            sort(mat, 0, col, m, n);  // sorts diagonal from row-0 --> cur-col
        }
        // iterating first column
        // col is constant 0, iterating diagonals that start from first col
        // then iterate row indicies
        for (int row=0; row<m; row+=1) {
            sort(mat, row, 0, m, n);    // sorts diagonal from col-0 --> cur-row
        }

        return mat;
        
    }

    void sort(int[][] mat, int row, int col, int m, int n) {
        // stores values of diagonal
        List<Integer> values = new ArrayList<>();
        int r = row;
        int c = col;
        // while given row/col indicies of current diagonal are less than max-rows-cols, increment both each iteration
        // so that the next element is on the same diagonal
        while (r < m && c < n) {
            values.add(mat[r][c]);      // collect values
            r += 1;
            c += 1;
        }
        Collections.sort(values);       // sort values

        r = row;
        c = col;
        int indx = 0;
        // iterate again
        while (r < m && c < n) {
            mat[r][c] = values.get(indx++);  // replace values
            r += 1;
            c += 1;
        }
    }
}

// NOTE: to iterate all diagonals we have to consider diagonals from first row and first column