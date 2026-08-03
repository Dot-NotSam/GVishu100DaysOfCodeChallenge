class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int res = nums[0]+nums[1]+nums[2];
        for(int i = 0; i < n-2; i++) {
            int j = i+1;
            int k = n-1;
            
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(target-sum) < Math.abs(target-res)) {
                    res = sum;
                }
                if (sum < target) j++;
                else if (sum > target) k--;
                else return sum;
                
            }
        }

        return res;
    }
}
