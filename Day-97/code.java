class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;

        for (int num : nums) total += num;
        
        int target = total-x;
        if (target < 0) return -1;
        if (target == 0) return n;

        int l = 0;
        int curr = 0;
        int max = -1;

        for (int r = 0; r < n; r++) {
            curr += nums[r];

            while (curr > target && l <= r) {
                curr -= nums[l];
                l++;
            }

            if (curr == target) {
                max = Math.max(max, r-l+1);
            }
        }

        if (max == -1) return -1;
        return n-max;
    }
}
