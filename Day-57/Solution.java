class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int tot = 0;
        boolean nonZero = false;

        for (int num : nums) {
            tot ^= num;
            if (num != 0) {
                nonZero = true;
            }
        }

        if(tot != 0) return n;
        else {
            if(!nonZero) return 0;
            else return n-1;
        }
    }
}
