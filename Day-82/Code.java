class Solution {
    public int maxScore(int[] cp, int k) {
        int n = cp.length;

        int tot = 0;
        for(int p : cp) tot += p;
        if(n == k) return tot;
        
        int curr = 0;
        int fs = tot;
        int ws = n-k;

        int i = 0;
        int j = 0;
        while(i < n) {
            curr += cp[i];
            while(j < i && i-j+1 > ws) curr -= cp[j++];
            if(i-j+1 == ws) fs = Math.min(curr, fs);
            i++;
        }

        return tot-fs;
    }
}
