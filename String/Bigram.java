class Bigram {
    public String[] findOcurrences(String text, String first, String second) {

        ArrayList<String> thirds = new ArrayList<String>();
        String[] words = text.split(" ");
        for (int i=0; i<words.length; i++) {
            // if cur is first and we can check for 3 element and cur+1 is second add the third
            if (words[i].equals(first) && i+2 <= words.length-1 && words[i+1].equals(second)) {
                thirds.add(words[i+2]);
            }
        }

        String[] output = new String[thirds.size()];

        for (int i=0; i<thirds.size(); i++) {
            output[i] = thirds.get(i);
        }
        return output;
        
    }
}


// 1078. Occurrences After Bigram
