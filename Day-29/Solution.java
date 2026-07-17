class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        func(candidates, n, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public void func(int[] arr, int n, int target,
                    List<List<Integer>> res, List<Integer> curr,
                    int sum, int idx) 
    {
        if(sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(idx == n || sum > target) {
            return;
        }

        curr.add(arr[idx]);
        func(arr, n, target, res, curr, sum+arr[idx], idx);
        curr.remove(curr.size()-1);
        func(arr, n, target, res, curr, sum, idx+1);
    }
}
