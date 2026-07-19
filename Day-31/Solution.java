class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        long ans = 0;
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for(int num : nums) {
            if(num < a) {
                ans += cnt2+cnt3;
                cnt1++;
            }
            else if (num <= b) {
                ans += cnt3;
                cnt2++;
            }
            else cnt3++;
        }

        return (int)(ans%MOD);
    }
}
