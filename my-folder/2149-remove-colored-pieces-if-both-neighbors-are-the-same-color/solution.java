class Solution {
    public boolean winnerOfGame(String colors) {
        int movesA = 0, movesB = 0;
        int countA = 0, countB = 0;

        for (char c : colors.toCharArray()) {
            if (c == 'A') {
                countA++;
                countB = 0;
                if (countA >= 3) {
                    movesA += countA - 2;
                }
            } 
            else{
                countB++;
                countA = 0;
                if (countB >= 3) {
                    movesB += countB - 2;
                }
            } 
        }

        return movesA > movesB;
    }
}

