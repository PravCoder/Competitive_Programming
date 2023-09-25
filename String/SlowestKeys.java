import java.util.*;

class SlowestKeys {
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        ArrayList<Integer> durations = new ArrayList<Integer>();

        for (int i=0; i<releaseTimes.length; i++) {
            if (i >= 1) {
                durations.add(releaseTimes[i]-releaseTimes[i-1]);
            } else {
                durations.add(releaseTimes[i]);
            }
        }

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        Character key = 'a';
        int maxDur = Collections.max(durations);

        if (Collections.frequency(durations, maxDur) > 1) {
            for (int i=0; i<keysPressed.length(); i++) {
                char letter = keysPressed.charAt(i);
                if (durations.get(i) == maxDur && alpha.indexOf(String.valueOf(letter)) > alpha.indexOf(String.valueOf(key))) {
                    key = letter;
                }
            }
            return key;
        } else {
            return keysPressed.charAt(durations.indexOf(maxDur));
        }

    }
}
// 1629. Slowest Key
