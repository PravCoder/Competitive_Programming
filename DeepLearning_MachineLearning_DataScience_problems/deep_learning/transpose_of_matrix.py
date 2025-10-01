# Transpose of Matrix
# Easy
# Deep-ML: https://www.deep-ml.com/problems/2

# Input: 2D-array. [[11, 12, 13], [21, 22, 23]], (mxn)
# Output: 2D-array transpose.  [], (nxm)
def transpose_matrix(a: list[list[int|float]]) -> list[list[int|float]]:

    # iterate through columns, turn then into rows
    num_rows = len(a)
    num_cols = len(a[0])

    transpose_a = []

    # iterate number of columns
    for j in range(num_cols):
        cur_col = []
        # iterate number of rows, iteate the rows for the jth-column which is like iterating the col, going down its rows
        for i in range(num_rows):
            cur_col.append(a[i][j])
        
        # afting getting all elements in jth col, add it as a row to transpose matrix
        transpose_a.append(cur_col)

    b = transpose_a
	return b