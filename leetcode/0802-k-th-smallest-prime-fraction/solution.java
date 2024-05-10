class Solution {
    class Pair{
        private int num;
        private int den;

        public Pair(int num, int den){
            this.num = num;
            this.den = den;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.num * b.den - a.den * b.num));

        int n = arr.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                pq.add(new Pair(arr[i], arr[j]));
            }
        }

        Pair result = null;
        while(k-- > 0){
            result = pq.poll();
        }
        return new int[]{result.num, result.den};
    }
}
