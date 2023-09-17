import java.util.HashMap;

class ReformatDate {
    public String reformatDate(String date) {
        
        String day = "";
        String month = "";
        String year = "";
        HashMap<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        boolean isTwoDay = true;
        try {
            String temp = "";
            temp += Integer.parseInt(date.substring(0, 2));
            isTwoDay = true;
        } catch (NumberFormatException e) {
            isTwoDay = false;
        }

        if (isTwoDay == true) {
            day += Integer.parseInt(date.substring(0, 2));
            month += monthMap.get(date.substring(5, 8));
            year += date.substring(9);
        }
        if (isTwoDay == false) {
            day += "0"+date.substring(0,1);
            month += monthMap.get(date.substring(4, 7));
            year += date.substring(8);
        }

        String formatted = year+"-"+month+"-"+day;
        return formatted;
    }   
}

// NOTE: we need to check if the month number is 1/2 digits because that throws off the formatting
// 1507. Reformat Date
