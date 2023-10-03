// Partial Solution
class AddStrings {
    public String addStrings(String num1, String num2) {
        // convert both to integers, convert string value of sums
        int total1 = 0;
        int total2 = 0;
        for (int i = 0; i < num1.length(); i++) {
            char cur = num1.charAt(i);
            int digit = Character.getNumericValue(cur);
            // multiplying by 10 because each iteration we move up 10 in the place value
            // so each iteration the total-integer will increase by a single place value
            // and add the actual digit value, after we have increased the place value of total-int
            total1 = (total1 * 10) + digit;
        }
        for (int i = 0; i < num2.length(); i++) {
            char cur = num2.charAt(i);
            int digit = Character.getNumericValue(cur);
            total2 = (total2 * 10) + digit;
        }
        return Integer.toString(total1 + total2);
    }
}
/// 415. Add Strings


// Failed testcas
// Input
// num1 =
// "6913259244"
// num2 =
// "71103343"
// Output
// "-1605572005"
// Expected
// "6984362587"