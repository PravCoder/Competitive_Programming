
class FindPrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        // each element is the number of common elements between A/B
        // fomr 0 to that index
        int[] prefixCommon = new int[n];
        // iterate indicies of output
        for (int i=0; i<n; i++) {
            ArrayList<Integer> aPrefix = new ArrayList<Integer>();
            ArrayList<Integer> bPrefix = new ArrayList<Integer>();
            // iterate a-indicies from 0 to cur-i and add A's element
            for (int a=0; a<=i; a++) {
                aPrefix.add(A[a]);
            }
            // iterate b-indicies from 0 to cur-i and add B's element
            for (int b=0; b<=i; b++) {
                bPrefix.add(B[b]);
            }

            int common = 0;
            // iterate A-sub-arr and see if that element exists in b-sub-arr and 
            // update count
            for (Integer aInt: aPrefix) {
                if (bPrefix.contains(aInt)) {
                    common += 1;
                }
            }
            // set the index-i equal to number of common elements in sub-arrays of
            // A/B from 0->i inclusive.
            prefixCommon[i] = common;
        }
        return prefixCommon;
        
    }
}
// 2657. Find the Prefix Common Array of Two Arrays
