class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xDiff = Math.abs(fx - sx);
        int yDiff = Math.abs(fy - sy);
        if(xDiff == 0 && yDiff == 0 && t == 1) return false;

        return Math.max(xDiff, yDiff) <= t;
    }
}
