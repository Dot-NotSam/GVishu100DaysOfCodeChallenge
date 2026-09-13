class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        int[][] ans = new int[n][n];
        int[][] res = new int[n][n];

        for(int i = 0; i < n; i++) {
            int k = rowShift[i];
            for(int j = 0; j < n; j++) {
                ans[i][(j-k+n)%n] = grid[i][j];
            }
        }
        
        for(int j = 0; j < n; j++) {
            int l = colShift[j];
            for(int i = 0; i < n; i++) {
                res[(i-l+n)%n][j] = ans[i][j]; 
            }
        }

        return res;
    }
}
