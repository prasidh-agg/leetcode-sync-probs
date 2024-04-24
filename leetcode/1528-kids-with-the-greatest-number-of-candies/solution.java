class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int greatest = 0;

        for(int candy : candies){
            greatest = Math.max(greatest, candy);
        }
        greatest -= extraCandies;

        for(int candy : candies){
            res.add(candy >= greatest);
        }
        return res;

    }
}
