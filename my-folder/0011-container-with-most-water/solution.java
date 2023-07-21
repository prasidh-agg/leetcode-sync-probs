class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0, ht = 0;
        while(left < right){
            ht = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, ht * (right - left));
            if(height[right] > height[left]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
