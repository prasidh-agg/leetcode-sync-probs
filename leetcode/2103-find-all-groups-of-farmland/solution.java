public class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 0) continue;

                //top left is i,j.. and bottom right is r1,c1
                int c1 = j;
                //keep increasing col till you can
                while(c1 < n && land[i][c1] == 1) c1++;

                int r1 = i;
                while(r1 < m && land[r1][j] == 1) r1++;

                //because the above for loops will break when the condition has become false, 
                //so we must decrease r1,c1 by 1
                c1 = c1 == 0 ? c1: c1 - 1;
                r1 = r1 == 0 ? r1: r1 - 1;
                res.add(new int[]{i, j, r1, c1});

                for(int k = i; k <= r1; k++){
                    for(int l = j; l <= c1; l++){
                        land[k][l] = 0; //visited all
                    }
                }
            }
        }

        int N = res.size();
        int[][] ans = new int[N][4];
        for(int i = 0; i < N; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
