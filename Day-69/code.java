class Solution {
    public int celebrity(int[][] M) {
        int n = M.length;
        
        int t = 0; 
        int d = n-1;
        while(t < d) {
            if(M[t][d] == 1) t++;
            else if(M[d][t]==1) d--;
            else {
                d--;
                t++;
            }
        }

        for(int i = 0; i < n; i++) {
            if(i == t) continue;

            if(M[t][i] == 1 || M[i][t] == 0) return -1;
        }

        return t;
    }
}
