class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int minOdd = Integer.MAX_VALUE;
        int idxOd = -1;

        for (int i = 0; i < n; i++) {
            if (nums1[i]%2 != 0) {
                if (nums1[i] < minOdd) {
                    minOdd = nums1[i];
                    idxOd = i;
                }
            }
        }
        if (idxOd == -1) return true;

        for (int i = 0; i<n; i++) {
            if (nums1[i]%2 != 0) continue;
            if (nums1[i]-minOdd < 1) return false;
        }

        return true;
    }
}
