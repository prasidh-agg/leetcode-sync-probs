class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = {{0, 1}, {-1,0}, {0,-1}, {1, 0}};
        int dirIdx = 0;
        int xcoord = 0;
        int ycoord = 0;
        
        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'G'){
                //what is my direction
                int xDelta = directions[dirIdx][0];
                int yDelta = directions[dirIdx][1];
                xcoord += xDelta;
                ycoord += yDelta;
            }
            else if(instructions.charAt(i) == 'L'){
                dirIdx = (dirIdx + 1) % 4;
            }
            else{
                dirIdx = (dirIdx + 3) % 4;
            }
        }
        return (xcoord == 0) && (ycoord == 0) || dirIdx != 0;
    }
}



