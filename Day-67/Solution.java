class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        for (int i = 1; i<n; i++) {
            stones[i] += stones[i-1];
        }

        int diff = stones[n-1];

        for (int i = n-2; i >= 1; i--) {
            diff = Math.max(diff, stones[i]-diff);
        }

        return diff;
    }
}
