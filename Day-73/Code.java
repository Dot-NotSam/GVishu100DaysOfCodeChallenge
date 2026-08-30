class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        if(n==2) return 2;

        int max[] = new int[2];
        int min[] = new int[2];
        max[0] = Integer.MIN_VALUE;
        min[0] = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(max[0] < nums[i]) {
                max[0] = nums[i];
                max[1] = i;            
            }

            if(min[0] > nums[i]) {
                min[0] = nums[i];
                min[1] = i;
            }
        }

        int minIdx = min[1];
        int maxIdx = max[1];

        int Min_distFromLeft= minIdx+1;
        int Min_distFromRight= n-minIdx;

        int Max_distFromLeft= maxIdx+1;
        int Max_distFromRight= n-maxIdx;

        int maxFromRight = Math.max(Min_distFromRight, Max_distFromRight);
        int maxFromLeft = Math.max(Min_distFromLeft, Max_distFromLeft); 
        int min_FromBoth = Math.min(maxFromRight, maxFromLeft);

        int minDist_MIN = Math.min(Min_distFromLeft, Min_distFromRight);
        int minDist_MAX = Math.min(Max_distFromLeft, Max_distFromRight);

        int dist_btwThem = Math.abs(minIdx-maxIdx);

        if(dist_btwThem >= minDist_MIN && 
           dist_btwThem >= minDist_MAX) {
            return minDist_MIN+minDist_MAX;
        }

        return min_FromBoth;
    }
}
