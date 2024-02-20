class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n == 0) return true;
        
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                boolean prev = (i == 0 || flowerbed[i-1] == 0);
                boolean next = (i == flowerbed.length - 1 || flowerbed[i+1] == 0);
                if(prev && next){
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
