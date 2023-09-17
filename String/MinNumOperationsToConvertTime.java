
 class MinNumOperationsToConvertTime {
    public int convertTime(String current, String correct) {

        String[] curr = current.split(":");
        String[] corr = correct.split(":");

        // convert each time into minutes
        int cur = Integer.parseInt(curr[0])*60 + Integer.parseInt(curr[1]);
        int cor = Integer.parseInt(corr[0])*60 + Integer.parseInt(corr[1]);

        int count = 0;
        // from largest step to lowest step add to current time
        while (cur + 60 <= cor) {
            cur += 60;
            count += 1;
        }
        while (cur + 15 <= cor) {
            cur += 15;
            count += 1;
        }
        while (cur +5 <= cor) {
            cur += 5;
            count += 1;
        }
        while (cur + 1 <= cor) {
            cur += 1;
            count += 1;
        }

        return count;
        
    }
}

// 2224. Minimum Number of Operations to Convert Time
