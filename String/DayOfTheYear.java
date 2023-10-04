import java.util.HashMap;

class DayOfTheYear {
    public int dayOfYear(String date) {
        // January, February, March, April, May, June, July, August, September, October, November December.
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12

        // hashmap = {month-num: days}
        HashMap<Integer, Integer> months = new HashMap<Integer, Integer>();
        months.put(1, 31);
        months.put(2, 28);
        months.put(3, 31);
        months.put(4, 30);
        months.put(5, 31);
        months.put(6, 30); // Add entry for June
        months.put(7, 31);
        months.put(8, 31);
        months.put(9, 30);
        months.put(10, 31);
        months.put(11, 30);
        months.put(12, 31);
        Integer year = Integer.parseInt(date.split("-")[0]);  // get year
        // check for leap year
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            months.put(2, 29); // Leap year, February has 29 days
        }

        Integer endMonth = Integer.parseInt(date.split("-")[1]);  // get month in string
        Integer numDays = Integer.parseInt(date.split("-")[2]);  /// get day-num of month in string
        int totalDays = 0;
        for (int i=1; i<endMonth; i++) { // iterate from 1st month to endMonth and sum the days of current month
            totalDays += months.get(i);
        }
        
        totalDays += numDays;  // add day-num in string to totalDays, because endMonth is excluded in iteration
        return totalDays;  // because we dont know if its the entire month or a fraction of its days
    }
}

// 1154. Day of the Year
