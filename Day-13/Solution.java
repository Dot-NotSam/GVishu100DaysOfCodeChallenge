// 😭🙏🏻

class Solution {
    int n;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        int[][] dist = distanceFromThief(grid);

        int low = 0;
        int high = 2*n;
        int ans = 0;

        while (low <= high) {
            int mid = (low+high)/2;

            boolean[][] visited = new boolean[n][n];

            if (dist[0][0] >= mid && explore(0, 0, mid, dist, visited)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans;
    }

    boolean explore(int r, int c, int need, int[][] dist, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= n || c >= n) return false;
        if (visited[r][c]) return false;
        if (dist[r][c] < need) return false;
        if (r == n-1 && c == n-1) return true;

        visited[r][c] = true;

        if (explore(r-1, c, need, dist, visited)) return true;
        if (explore(r+1, c, need, dist, visited)) return true;
        if (explore(r, c-1, need, dist, visited)) return true;
        if (explore(r, c+1, need, dist, visited)) return true;

        return false;
    }

    int[][] distanceFromThief(List<List<Integer>> grid) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            if (r-1 >= 0 && dist[r-1][c] == -1) {
                dist[r-1][c] = dist[r][c]+1;
                q.offer(new int[]{r-1, c});
            }

            if (r+1 < n && dist[r+1][c] == -1) {
                dist[r+1][c] = dist[r][c]+1;
                q.offer(new int[]{r+1, c});
            }

            if (c-1 >= 0 && dist[r][c-1] == -1) {
                dist[r][c-1] = dist[r][c]+1;
                q.offer(new int[]{r, c-1});
            }

            if (c+1 < n && dist[r][c+1] == -1) {
                dist[r][c+1] = dist[r][c]+1;
                q.offer(new int[]{r, c+1});
            }
        }

        return dist;
    }
}
