class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {
        int m = rs.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < rs.length; i++) {
            int r = rs[i][0];
            int s = rs[i][1];
            if (!map.containsKey(r)) {
                map.put(r, new HashSet<>());
            }
            map.get(r).add(s);
        }

        int res = 0;
        for (int i : map.keySet()) {
            HashSet<Integer> s = map.get(i);

            boolean left = !s.contains(2) &&
                        !s.contains(3) &&
                        !s.contains(4) &&
                        !s.contains(5);

            boolean middle = !s.contains(4) &&
                            !s.contains(5) &&
                            !s.contains(6) &&
                            !s.contains(7);

            boolean right = !s.contains(6) &&
                            !s.contains(7) &&
                            !s.contains(8) &&
                            !s.contains(9);

            if (left && right) {
                res += 2;
            }
            else if (left || middle || right) {
                res += 1;
            }
        }

        return res + (n-map.size())*2;
    }
}
