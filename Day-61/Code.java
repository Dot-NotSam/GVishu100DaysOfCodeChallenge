class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int res = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        if(k==n) {
            for(int i : nums) {
                res = Math.max(i, res);
            }
            return res;
        } else if (k==1) {
            for(int i : nums) {
                if(map.get(i) == 1) {
                    res = Math.max(res, i);
                }
            }
            return res;
        } else {
            if(map.get(nums[0]) == 1) {
                res = Math.max(res, nums[0]);
            }
            if (map.get(nums[n-1]) == 1) {
                res = Math.max(res, nums[n-1]);
            }
            return res;
        }

    }
}
