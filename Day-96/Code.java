class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        func(k, n, res, new ArrayList<>(), 0, 0, 1);
        return res;
    }

    public void func(int k, int n, List<List<Integer>> res,
                    List<Integer> curr, int sum, int idx, int num) 
    {

        if(idx == k) {
            if(sum == n) {
                res.add(new ArrayList<>(curr));
                return;
            }
            return;
        }

        if(sum > n) return;

        for(int i = num; i <= 9; i++) {
            curr.add(i);
            func(k, n, res, curr, sum+i, idx+1, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
