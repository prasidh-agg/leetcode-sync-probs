class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        Arrays.sort(potions);
        int[] res = new int[m];

        for(int i = 0; i < m; i++){
            //for every spell.. find the lower bound in potions.
            int l = 0, r = n - 1;

            int target = (int)Math.ceil((double)success/spells[i]);

            if (target > potions[n - 1]) {
                res[i] = 0;
                continue;
            }

            if (target < potions[0]) {
                res[i] = n;
                continue;
            }

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (potions[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            res[i] = n - l;
        }
        return res;
    }
}
