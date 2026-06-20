class Solution {
    public int maxBuilding(int n, int[][] rest) {
        int m = rest.length;
        if (m == 0) return n-1;
    
        Arrays.sort(rest, (a, b) -> Integer.compare(a[0], b[0]));

        rest[0][1] = Math.min(rest[0][1], rest[0][0]-1);

        for (int i = 1; i < m; i++) {
            int currId = rest[i][0];
            int currH = rest[i][1];
            int prevId = rest[i-1][0];
            int prevH = rest[i-1][1];

            int maxPossible = prevH + (currId-prevId);

            rest[i][1] = Math.min(currH, maxPossible);
        }

        for (int i = m-1; i > 0; i--) {
            int currId = rest[i][0];
            int currH = rest[i][1];
            int prevId = rest[i-1][0];
            int prevH = rest[i-1][1];

            int maxPossible = currH + (currId-prevId);

            rest[i-1][1] = Math.min(prevH, maxPossible);
        }

        int ans = 0;

        ans = Math.max(ans, rest[0][1] + (rest[0][0]-1)/2);

        for (int i = 1; i < m; i++) {
            int prevId = rest[i-1][0];
            int prevH = rest[i-1][1];
            int currId = rest[i][0];
            int currH = rest[i][1];

            int dist = currId-prevId;

            int peak = Math.max(prevH, currH)
                     + (dist - Math.abs(prevH - currH))/2;

            ans = Math.max(ans, peak);
        }

        int lastId = rest[m-1][0];
        int lastH = rest[m-1][1];

        ans = Math.max(ans, lastH + (n-lastId));

        return ans;
    }
}
