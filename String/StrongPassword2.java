
class StrongPassword2 {
    public boolean strongPasswordCheckerII(String password) {

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean hasAdj = false;
        String specialChars  = "!@#$%^&*()-+";

        for (int i=0; i<password.length(); i++) {
            char cur = password.charAt(i);
            if (Character.isLetter(cur)  && Character.isLowerCase(cur) == true) {
                System.out.println("1: "+cur);
                hasLower = true;
            }
            if (Character.isLetter(cur) && Character.isUpperCase(cur) == true) {
                System.out.println("2: "+cur);
                hasUpper = true;
            }
            if (Character.isDigit(cur) == true) {
                System.out.println("3: "+cur);
                hasDigit = true;
            }
            if (i > 0 && cur == password.charAt(i-1)) {
                System.out.println("4: "+cur);
                hasAdj = true;
            }
            // specia condition
            for (int j=0; j<specialChars.length(); j++) {
                char s = specialChars.charAt(j);
                if (s == cur) {
                    hasSpecial = true;
                    System.out.println("5: "+cur);
                    break;
                }
            }
        }

        if (hasLower==true && hasUpper==true && hasDigit==true && hasSpecial==true && hasAdj == false && password.length() >= 8) {
            return true;
        }
        return false;
        
    }
}

// 2299. Strong Password Checker II