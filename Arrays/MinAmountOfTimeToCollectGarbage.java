
class MinAmountOfTimeToCollectGarbage {
    public int garbageCollection(String[] garbage, int[] travel) {

        int paperMins = 0;  // stores total number of minutes per each type of garbage
        int glassMins = 0;
        int metalMins = 0;
        
        int lastPaper = -1;  // stores last-index of house that each garbage type appears
        int lastGlass = -1;
        int lastMetal = -1;

        // add number of picks for each garbage type
        // iterate indicies of houes
        for (int h=0; h<garbage.length; h++) {
            // iterate the garbage characters of cur-house-string
            for (int c=0; c<garbage[h].length(); c++) {
                // if its paper update then it takes 1 min to update paperMins
                // update the last index that a paper appears in house with house-indx
                if (garbage[h].charAt(c) == 'P') {
                    paperMins += 1;
                    lastPaper = Math.max(lastPaper, h);
                }
                if (garbage[h].charAt(c) == 'G') {
                    glassMins += 1;
                    lastGlass = Math.max(lastGlass, h);
                }
                if (garbage[h].charAt(c) == 'M') {
                    metalMins += 1;
                    lastMetal = Math.max(lastMetal, h);
                }
            }
        }

        // add travel items for each garbage type
        // iterate the indicices of the houses starting frmo first house to lastPaper-house
        // excluding the last-paper-house-indx because we are indexing the travel times
        for (int t=0; t<lastPaper; t++) { 
            paperMins += travel[t];
        }
        for (int t=0; t<lastGlass; t++) { 
            glassMins += travel[t];
        }
        for (int t=0; t<lastMetal; t++) { 
            metalMins += travel[t];
        }
        
        System.out.println("\nlastPaper: "+lastPaper);
        System.out.println("P: "+paperMins);
        System.out.println("G: "+glassMins);
        System.out.println("M: "+metalMins);
        // sum total mins
        return paperMins + glassMins + metalMins;
        
    }
}


// NOTE: travel is 1 less than garbage because it is the travel time between the elements of // ////// garbage. For example if lasta paper is house-indx-2 then we iterate 0,1 and add the travel times
// 2 + 4, just like in the first example. 
// (2 + 4) + 2 = 8, for paper
// travel_time + garbage_picked
// have to start from house 0














