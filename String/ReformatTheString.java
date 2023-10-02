import java.util.ArrayList;

class ReformatTheString {
    public String reformat(String s) {
        // store letters/numbers in respective lists
        ArrayList<Character> letters = new ArrayList<Character>();
        ArrayList<Character> digits = new ArrayList<Character>();
        // itearte characters and add it lists
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isAlphabetic(cur) == true) {
                letters.add(cur);
            }
            else if (Character.isDigit(cur) == true) {
                digits.add(cur);
            }
        }
        System.out.println(letters.size());
        System.out.println(digits.size());
        // for a valid alternating string need to ahve same number of letters/digits
        // for letters/digits either on needs to have 1 more than the other
        if (letters.size() != digits.size() && Math.abs(letters.size()-digits.size()) != 1) {
            return "";
        }

        String reformatted = "";
        // if there are more letters than digits
        if (letters.size() > digits.size()) {
            // iterate letters
            for (int i=0; i<letters.size(); i++) {
                // if its not the last-index of smaller-list add both
                if (i <= digits.size()-1) {
                    reformatted += letters.get(i);
                    reformatted += digits.get(i);
                } else { /// if its the last-index of smaller only add bigger
                    reformatted += letters.get(i);
                }
                
            }
        }
        if (digits.size() > letters.size()) {
            for (int i=0; i<digits.size(); i++) {
                if (i <= letters.size()-1) {
                    reformatted += digits.get(i);
                    reformatted += letters.get(i);
                } else {
                    reformatted += digits.get(i);
                }
            }
        }
        if (letters.size() == digits.size()) {
            for (int i=0; i<letters.size(); i++) {
                reformatted += letters.get(i);
                reformatted += digits.get(i);
            }
        }
        return reformatted;
    }
}

// 1417. Reformat The String
