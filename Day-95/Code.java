// 3524. Find X Value of Array I
  
class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];
        long[] prev = new long[k];

        for (int num : nums) {
            int rem = num%k;
            long[] curr = new long[k];
            curr[rem]++;

            for (int i = 0; i<k; i++) {
                int newRem = (i*rem)%k;
                curr[newRem] += prev[i];
            }

            for (int j = 0; j<k; j++) {
                res[j] += curr[j];
            }

            prev = curr;
        }

        return res;
    }
}
