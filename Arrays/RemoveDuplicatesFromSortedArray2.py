class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        after_remove = [] # stores elements after removing
        k = 0
        # iterate nums
        for n in nums:
            # if the cur-element occurs more than twice or equal to 2 and we havent added to post deletion array, add 2 of its occurances
            if nums.count(n) >= 2 and n not in after_remove:
                after_remove.append(n)
                after_remove.append(n)
            # if the cur-element occurs less than twice so it has no duplicqatesn and we havent added to post deletion array, add its only occurance
            elif nums.count(n) < 2 and n not in after_remove:
                after_remove.append(n)

        # k is length of the post deletion array
        k = len(after_remove)
        print(k)

        # since after-remove is the first-part of the result-array the first k elements, just replace those in nums
        for i in range(len(after_remove)):
            nums[i] = after_remove[i]


        return k

# NOTE: each unqiue element should appear at most twice, either once or twice. Order of elements should be kept. After removing these duplicates
# the remianiong elements should be in the beginning of the array - with order maintinaed - and deleted elements can be after that. Nums is sorted in 
# increasing order so duplicates are adjacent. 