class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for(int i : nums) {
            small = Math.min(small, i);
            large = Math.max(large, i);
            set.add(i);
        }
        
        for(int i = small; i <= large; i++) {
            if(!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}
