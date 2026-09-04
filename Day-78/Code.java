class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int suff[] = new int[n];
        int min = Integer.MAX_VALUE;

        for(int i = n-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            suff[i] = min;
        }

        int max = -1;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);

            if(max-suff[i] <= k) return i;
        }

        return -1;
    }
}
