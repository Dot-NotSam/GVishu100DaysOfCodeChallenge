class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] oi, int fs, int fe) {

        int n = oi.length;
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(oi, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < n; i++) {
            if(list.isEmpty()) {
                List<Integer> curr = new ArrayList<>();
                curr.add(oi[i][0]);
                curr.add(oi[i][1]);
                list.add(curr);
            } else {
                List<Integer> last = list.get(list.size()-1);

                if(oi[i][0] <= last.get(1)+1) {
                    last.set(1, Math.max(last.get(1), oi[i][1]));
                } else {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(oi[i][0]);
                    curr.add(oi[i][1]);
                    list.add(curr);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> op : list) {
            int s = op.get(0);
            int e = op.get(1);

            if(fs > e || fe < s) {
                ans.add(Arrays.asList(s, e));
            }
            else if(s >= fs && e <= fe) continue;
            
            else if(s < fs && e > fe) {
                ans.add(Arrays.asList(s, fs-1));
                ans.add(Arrays.asList(fe+1, e));
            }
            else if(s < fs) {
                ans.add(Arrays.asList(s, fs-1));
            }
            else {
                ans.add(Arrays.asList(fe+1, e));
            }
        }
        
        return ans;
    }
}
