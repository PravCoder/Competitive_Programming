class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # if starting cell is equal to new-color return base case
        if image[sr][sc] == color:
            return image
        # start recursion, pass in og-image, starting row-col, starting-element's color, and new-color
        self.fill(image, sr, sc, image[sr][sc], color)
        return image

    def fill(self, image, row, col, starting_color, new_color):
        # if given row-col-indices are out of range OR element at row-col is not equal to starting-color, then we can return
        # this recursive call
        if row<0 or col<0 or row>=len(image) or col>=len(image[row]) or image[row][col] != starting_color:
            return
        
        # if given row-col is same as starting color change it to new color
        if image[row][col] == starting_color: image[row][col] = new_color

        # call function recursivelly on all 4-directions
        self.fill(image, row-1, col, starting_color, new_color)
        self.fill(image, row+1, col, starting_color, new_color)
        self.fill(image, row, col-1, starting_color, new_color)
        self.fill(image, row, col+1, starting_color, new_color)
