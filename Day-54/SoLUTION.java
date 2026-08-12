class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int freq = map.get(nums[i]);

                if (freq < k) {
                    map.put(nums[i], freq+1);
                } else {
                    while (j <= i && nums[j] != nums[i]) {
                        map.put(nums[j], map.get(nums[j])-1);
                        if (map.get(nums[j]) == 0) {
                            map.remove(nums[j]);
                        }
                        j++;
                    }

                    map.put(nums[j], map.get(nums[j])-1);

                    if (map.get(nums[j]) == 0) {
                        map.remove(nums[j]);
                    }
                    j++;

                    map.put(nums[i], map.getOrDefault(nums[i],0)+1);
                }
            } else {
                map.put(nums[i], 1);
            }

            res = Math.max(res, i-j+1);
        }

        return res;
    }
}
