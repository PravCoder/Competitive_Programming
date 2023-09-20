
class SumDigitsStringAfterConvert {
    public int getLucky(String s, int k) {

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int j=0; j<s.length(); j++) {
            char c = Character.toLowerCase(s.charAt(j));
            s = s.substring(0, j)+ Integer.toString(alpha.indexOf(c+1))+ s.substring(j+1, s.length());
        }

        for (int i=0; i<k; i++) {
            System.out.println(s);
            int sum = 0;
            for (int j=0; j<s.length(); j++) {
                sum += Integer.parseInt(Character.toString(s.charAt(j)));
            }
            s = Integer.toString(sum); 
        }
        System.out.println(s);
        return Integer.parseInt(s);
    }
}
// 1945. Sum of Digits of String After Convert
