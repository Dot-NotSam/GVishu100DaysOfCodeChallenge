class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int op = 0;

        for(int i = 0; i < n; i++) {
            boolean found = false;
            int x = 101;
            for(int num : nums) {
                if(num > 0) {
                    x = Math.min(x, num);
                }
            }

            if(x == 101) break;

            for(int j = 0; j < n; j++) {
                if(nums[j] > 0 ) {
                    nums[j] -= x;
                    found = true;
                }
            }
            if(found) op++;
        }

        return op;
    }
}
