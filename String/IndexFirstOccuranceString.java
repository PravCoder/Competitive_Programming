
class IndexFirstOccuranceString {
    public int strStr(String haystack, String needle) {

        // iterate characters of haystack-string
        for (int i=0; i<haystack.length(); i++ ) {
            char cur = haystack.charAt(i);  // get current character in haystack
            // if cur-char is equal to first character in needle, then it needle possibly exists 
            if (cur == needle.charAt(0)) {
                String contructed = "";  // constructed-substring of lenght neddle starting from index-i
                // iterate indicies of needle-string
                for (int j=0; j<needle.length(); j++) {
                    int k = i+j; // index in hahstack = base-i+needle-indx
                    // if k is within lenght of haystack-string
                    if (k <= haystack.length()-1) {
                        // if haystack cahraetr is equal to the cooresponding character in needle
                        // add that character to constructed-stirng
                        if (haystack.charAt(k) == needle.charAt(j)) {
                            contructed += haystack.charAt(k);
                        }
                        // if at any point constructed characters are not equal then substring equivalent
                        // to needle is not possible so break
                        else {
                            break;
                        }
                    }
                }
                // after constructing substring from haystack-stirng starting from indx-i
                // check if it euqals needle-string and return the starting-base-indx
                if (contructed.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
        
    }
}

// 28. Find the Index of the First Occurrence in a String

// Patterns: Substring Construction, Element Location/Existence.