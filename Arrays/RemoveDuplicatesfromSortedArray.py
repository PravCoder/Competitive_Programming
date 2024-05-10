class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # K is number of unique elements
        # Nums is given sorted
        # The first k elements in nums should be the unqiue elements, the rest can be the duplicates
        # of those elements

        # compute k
        k = 0 
        visited = [] # stores unique elements in order that they appear to perserve order
        for n in nums:  # iterate nums
            if n not in visited: # if we havent visisted cur-num
                visited.append(n) # added to visited and increment because we encountered unqiue element
                k += 1

        # iterate visited nodes which is length of k
        for i in range(len(visited)):
            nums[i] = visited[i] # set cur-index-nums equal to the visisted-i-num

        print(f"nums: {nums}")
        return k

# NOTE: in nums the first k elements should be reserved for the unqiue elements in the order that they appear