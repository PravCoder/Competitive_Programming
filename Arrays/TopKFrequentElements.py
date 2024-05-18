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

    