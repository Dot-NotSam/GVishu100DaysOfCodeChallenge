class Solution {
    public int func(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int ans = 0;

        while(i < n) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

            while(j<=i && map.size()>k) {
                map.put(nums[j], map.get(nums[j])-1);

                if(map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }

            ans += i-j+1;
            i++;
        }

        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums, k) - func(nums, k-1);
    }
}
