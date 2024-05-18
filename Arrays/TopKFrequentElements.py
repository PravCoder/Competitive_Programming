class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        count = {}
        # stores freqencies of elements in hashmap
        for n in nums:
            if n not in list(count.keys()):
                count[n] = 1
            elif n in list(count.keys()):
                count[n] += 1

        # given the hashmap returns the key with the maximum value 
        def get_max_key():
            max_key = list(count.keys())[0]
            for key in count.keys():
                if count[key] > count[max_key]:
                    max_key = key
            return max_key


        top_k = []  # stores the top-k most occuring elements
        for i in range(k):  # iterate the k places
            cur_max = get_max_key() # get the kth most occuring key
            top_k.append(cur_max) # add it and deolete from hashmap to get the next kth most occuring key
            del count[cur_max]
        
        return top_k


# TIME LIMIT EXCEEDED
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        count = {}  # {occurances: [v,a,l,u,e,s, in nums that occur that many times]}, key is occurances either 0 to length of list, value is the elements in nums that occur that many times

        for i in range(0, len(nums)+1):  # init with empty list
            count[i] = []

        for n in nums: # count up
            n_freq = nums.count(n)
            if n not in count[n_freq]:
                count[n_freq].append(n)
        
        l = 0   # stores number of elements we have added to top_k
        top_k = [] 
        for j in range(len(nums), -1, -1):  # iterate from last-occurance value to 0
            if len(count[j]) > 0 and l < k:    # if there are elements at occur that many times and we havent reached kth limit 
                for value in count[j]:         # add each value that occurs that many times tom top-k and increment l
                    l += 1
                    top_k.append(value)
            if l == k:
                return top_k

        print(count)
        return top_k

        
# NOTE: Bucket Sort (modified)

    