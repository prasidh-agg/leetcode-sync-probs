/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int firstHalf = binarySearchAsc(target, mountainArr, peak);
        return firstHalf != -1 ? firstHalf : binarySearchDesc(target, mountainArr, peak);
    }
    private int findPeak(MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
    private int binarySearchAsc(int target, MountainArray mountainArr, int peak){
        int l = 0, r = peak;
        while(l <= r){
            int mid = l + (r-l)/2;
            int ele = mountainArr.get(mid);
            if(ele == target) return mid;
            else if(ele < target) l = mid + 1;
            else r = mid - 1;
        }
        return - 1;
    }
    private int binarySearchDesc(int target, MountainArray mountainArr, int peak){
        int l = peak, r = mountainArr.length() - 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            int ele = mountainArr.get(mid);
            if(ele == target) return mid;
            else if(ele > target) l = mid + 1;
            else r = mid - 1;
        }
        return - 1;
    }
}
