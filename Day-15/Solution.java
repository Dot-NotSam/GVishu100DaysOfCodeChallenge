class Solution {
    public int findClosestNumber(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i]) < Math.abs(res)) {
                res = nums[i];
            } 
            else if (Math.abs(nums[i]) == Math.abs(res)) {
                if (nums[i] > res) {
                    res = nums[i];
                }
            }
        }

        return res;
    }
}
