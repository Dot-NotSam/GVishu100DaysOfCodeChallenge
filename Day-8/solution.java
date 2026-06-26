class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int targetCount = 0;
            for(int j = i; j < nums.length; j++) {
                if(target == nums[j]) {
                    targetCount++;
                }
                int len = j-i+1;
                if(targetCount > len/2) {
                    count++;
                }
            }
        }
        return count;
    }
}
