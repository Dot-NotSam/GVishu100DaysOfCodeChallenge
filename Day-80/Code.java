class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        int i = 0;
        int j = 0;
        int one = 0;
        int zero = 0;

        if (k == 0) {
            int consecZero = 0;
            for (int num : nums) {
                if (num == 0) {
                    consecZero++;
                    cnt += consecZero;
                } else {
                    consecZero = 0;
                }
            }
            return cnt;
        }

        while (i < n) {
            one += nums[i];

            while (j <= i && one > k) {
                one -= nums[j++];
                zero = 0;
            }

            if (one == k) {
                while (j<i && nums[j] == 0) {
                    zero++;
                    j++;
                }

                cnt += zero+1;
            }

            i++;
        }

        return cnt;
    }
}
