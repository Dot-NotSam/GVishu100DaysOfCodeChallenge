class Solution {
    public int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a%b);
    }
    
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
    
        int max = -1;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = GCD(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        int left = 0;
        int right = n-1;
        long sum = 0;
        while(left < right) {
            sum += GCD(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return sum;
    }
}
