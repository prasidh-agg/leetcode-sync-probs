class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 0, right = 1L * ranks[0] * cars * cars;

        while(left < right){
            long mid = (left + right) / 2;
            long count = 0;
            for(int rank : ranks){
                count += (long)Math.sqrt(mid / rank);
            }
            if(count < cars){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;

    }
}
//1,2,3,4, cars = 10
// l = 0, r = 400
