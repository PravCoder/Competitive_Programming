
class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        // replace all space substring with nothing
        // replace all - substring with nothing
        number = number.replaceAll("\\s", "");
        number = number.replaceAll("-", "");
        
        // stores output-string
        String formatted = "";
        // while we are allowed to create 3-digit blocks
        while (number.length() > 4) {
            formatted += number.substring(0, 3)+"-";  // add 3-block
            number = number.substring(3, number.length()); // remove add-block 0-3

        }
        System.out.println(formatted);
        System.out.println(number);

        // add rest of digits based on 3 conditions
        if (number.length() == 2 || number.length() == 3) {
            formatted += number;
        }
        if (number.length() == 4) {
            formatted += number.substring(0, 2);
            formatted += "-";
            formatted += number.substring(2, number.length());
        }
        return formatted;
    }
}

// NOTE: if there are greater than 4 digits left add a 3-block, 
// then if ther are 4 or fewer digits gorup them as one 
// of the 3 conditions

// 123456
// 123-456

// 1234567
// 123-45-67

// 12345678
// 123-456-78

// 1694. Reformat Phone Number
