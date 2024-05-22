class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        output = [0]*len(code)
        if k == 0: # base case
            return output
        # iterate each element in code
        for i in range(len(code)):
            # if k is greater than 0 we are moving forward
            if k > 0:
                i_sum = 0 # stores sum of next k-elements
                c = i+k   # cur-indx plus k it maybe out of bounds of inbounds = last-indx
                # if c is more than last-arr-indx, out of bounds
                if c > len(code)-1:
                    overflow = c - (len(code)-1) # after we reach the last-indx, we need to loop back to first element, so total minuslast-indx gives us number of spots left over or the last-indx we have to go to after looping
                    for j in range(i+1, len(code)): # after cur-indx to end of arr aggregate sum
                        i_sum += code[j]
                    for g in range(0, overflow):    # loop: from first-indx to just before overflow aggregate sum
                        i_sum += code[g]
                # if c is less than last-indx it is in bounds
                if c <= len(code)-1:
                    for j in range(i+1, c+1): # after cur-indx to last-indx+1 to include aggregate sum
                        i_sum += code[j]
                        
                output[i] = i_sum # replace ith element with ith=sum
            # if k is less than 0 we are moving backward
            if k < 0:
                i_sum = 0
                c = i - abs(k) # cur-indx minus positive k it maybe out bound or in bounds = last-indx where we have to stop
                # if c is less than start-indx, out of bounds
                if c < 0:
                    underflow = (len(code)-1) - abs(c) # after we keep going back, starting from end of list at twhat index do we have to stop
                    for j in range(i-1, -1, -1):  # before cur-indx to start-indx aggregate sum
                        i_sum += code[j]
                    for g in range(len(code)-1, underflow, -1):  # from last-indx to just before last-indx in which we have to go aggregate sum
                        i_sum += code[g]
                # if c is greater than start-indx, in bounds
                if c >= 0:
                    for j in range(i-1, i-abs(k)-1, -1): # before cur-indx to cur-indx minus spots minus 1 to include aggregate
                        i_sum += code[j]

                output[i] = i_sum
        
        return output

# NOTE: try an example to understand each variable. 