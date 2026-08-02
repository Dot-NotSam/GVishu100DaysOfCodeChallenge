class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) total += x;

        int player1 = solve(nums, 0, n-1, true);
        int player2 = total - player1;

        return player1 >= player2;
    }

    int solve(int[] nums, int l, int r, boolean turn) {
        if (l > r) return 0;

        if (turn) {
            int left = nums[l] + solve(nums, l+1, r, false);
            int right = nums[r] + solve(nums, l, r-1, false);

            return Math.max(left, right);

        } else {
            int left = solve(nums, l+1, r, true);
            int right = solve(nums, l, r-1, true);

            return Math.min(left, right);
        }
    }
}
