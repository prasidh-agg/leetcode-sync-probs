class Solution {
    public int minPartitions(String n) {
        for (int i = 9;;i--){
            if (n.contains(String.valueOf(i))){
                return i;
            }
        }
    }
}
