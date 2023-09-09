class MinSubstringAfterRemoving {
    public int minLength(String s) {
        
        // while any of the flags exist
        while (s.indexOf("AB") >= 0 || s.indexOf("CD") >= 0) {
            var i = s.indexOf("AB"); // get starting index of each flag
            var j = s.indexOf("CD");

            if (i >= 0) {
                // from beginning to flag skip for lenght of flag to end of list
                // this excludes the indicies of the flag
                s = s.substring(0, i) + s.substring(i+2, s.length());
            }
            else if (j >= 0) {
                s = s.substring(0,j) + s.substring(j+2, s.length());
            }
        }

        return s.length();
    }
}

// NOTE: write down the intervals of the substring method