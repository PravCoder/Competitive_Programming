class Solution:
    def minDeletionSize(self, strs) -> int:
      num_deletions = 0
      alpha = "abcdefghijklmnopqrstuvwxyz"
      num_cols = len(strs[0])
      # create 2d list each array is a column
      columns = [[] for _ in range(num_cols)]
      # iterate through the strs
      for i, row in enumerate(strs):
        # iterate through the indicies of the string
        for col in range(num_cols):
          # add the current character in string to the corresponding column using 
          # col-indx which is index of current column
          columns[col].append(row[col])
      # iterate through each created column
      for col in columns:
        # if sorted is not equal to original delete that column
        if sorted(col) != col:
          num_deletions += 1
          if num_deletions == num_cols:
            print("aa")
            return num_deletions
      

      return num_deletions