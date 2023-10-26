public class Solution {
    private static final int MOD = 1000000007;

    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        Map<Integer, Long> mp = new HashMap<>();
        long result = 0;

        for (int i = 0; i < n; i++) {
            long count = 1;

            for (int j = 0; j < i; j++) {
                int v = arr[j];
                if (arr[i] % v == 0 && mp.containsKey(arr[i] / v)) {
                    count += (mp.get(v) * mp.get(arr[i] / v)) % MOD;
                    count %= MOD;
                }
            }

            mp.put(arr[i], count);
            result = (result + count) % MOD;
        }

        return (int) result;
    }
}

