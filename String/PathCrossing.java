import java.util.ArrayList;

class Solution {
    public boolean isPathCrossing(String path) {

        int x = 0;
        int y = 0;
        ArrayList<String> coors = new ArrayList<String>();
        coors.add("0,0");

        for (int i=0; i<path.length(); i++) {
            char move = path.charAt(i);
            if (move == 'N') {
                y += 1;
            }
            if (move == 'S') {
                y -= 1;
            }
            if (move == 'E') {
                x += 1;
            }
            if (move == 'W') {
                x -= 1;
            }
            String curPosStr = x+","+y;
            System.out.println(coors);
            if (coors.contains(curPosStr) == true) {
                System.out.println(curPosStr + " already exists");
                return true;
            }
            
            coors.add(curPosStr);

        }
        
        return false;
    }

}

// N-> up
// S-> down
// E-> right
// W-> left

// 1496. Path Crossing
