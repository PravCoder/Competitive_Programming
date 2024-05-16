class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        # Create a set to hold distinct values
        distinct = set()

        # Add each number to the set to remove duplicates
        for n in nums:
            distinct.add(n)
        
        # Convert the set back to a list and sort it in descending order
        distinct = list(distinct)
        distinct.sort(reverse=True)
        
        # Check the length of the distinct list to determine what to return
        if len(distinct) < 3:
            return distinct[0]
        else:
            return distinct[2]

# NOTE: this is a weird problem where the conditions are not cleaerly communicated.