
class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {

        for (int i=0; i<words.length-1; i++) {
            String cur = words[i];
            String next = words[i+1];

            int c = 0;
            int n = 0;

            while (cur.charAt(c) == next.charAt(n)) {
                if (c+1 <= cur.length()-1) {
                    c += 1;
                }
                else if (c+1 >= cur.length()-1) {
                    break;
                }

                if (n+1 <= next.length()-1) {
                    n += 1;
                }
                else if (n+1 >= next.length()-1) {
                    break;
                }
            }
            System.out.println("c: " + cur.charAt(c) +" n: "+next.charAt(n));
            System.out.println(order.indexOf(cur.charAt(c))+" "+ order.indexOf(next.charAt(n)));
            System.out.println("---");
            if (order.indexOf(cur.charAt(c)) > order.indexOf(next.charAt(n))) {
                return false;
            }
        }
        return true;
    }
}

// 953. Verifying an Alien Dictionary
