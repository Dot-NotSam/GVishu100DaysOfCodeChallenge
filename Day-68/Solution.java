class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int op = k;
        while (set.contains(op)) {
            op += k;
        }

        return op;
    }
}
