class Solution:
    def checkXMatrix(self, grid: List[List[int]]) -> bool:
        n = len(grid) # grid is square
        # for primary diagonal iterate through all row-indicies,col-indicies and if they are equal then that element is on primary diagonal
        primary_diagonal = []
        for i in range(n):
            for j in range(n):
                if i == j:
                    primary_diagonal.append(grid[i][j])
        print(f"primary: {primary_diagonal}")

        # for secondary diagonal iterate from 0 to last-indx and store each indx in row-indicies, for column indicies of secondary diagonal
        # iterate from last-indx to 0-indx, then loop through both lists in tandem there lenghts are equal and get teh row-indx,col-indx pair and
        # and that element is on secondary-diagonal
        secondary_diagonal = []
        row_indicies = []
        col_indicies = []
        for i in range(0, n): 
            row_indicies.append(i)
        for j in range(n-1, -1, -1): 
            col_indicies.append(j)
        for k in range(len(row_indicies)):
            r = row_indicies[k]
            c = col_indicies[k]
            secondary_diagonal.append(grid[r][c])
        print(f"second: {secondary_diagonal}")

        # for other elements it is not an other element is indicies are equal or their sum is equal to last indx
        for i in range(n):
            for j in range(n):
                if i == j or i + j == n - 1:
                    continue
                else:
                    if grid[i][j] != 0:
                        return False
        # valid diagonal check
        if 0 not in primary_diagonal and 0 not in secondary_diagonal:
            return True
            
        # reutrn false if there is 0 in any diagonal
        return False

# primary: (0,0) (1,1) (2,2) .... row-indx col-indx is same for primary diagonal
# secondary: (0,3) (1,2) (2,1) (3,0), row-indx increasing to max, col-indx decreasing to 0
# non-diagonal: (0,1) (0,2) (2,3) (3,3)

# 2319. Check if Matrix Is X-Matrix