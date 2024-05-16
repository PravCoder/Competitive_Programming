class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        intersection = []

        for n in nums1:
            if n in nums2 and n not in intersection:
                intersection.append(n)

        return intersection
    

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        intersection = set() # set only unqiue elements so don;t have to check if n exists in intersection before adding saves time

        for n in nums1:
            if n in nums2:
                intersection.add(n)

        return intersection