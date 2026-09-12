class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int ans = Integer.MAX_VALUE;
        int idx = 0;

        int i = 0;
        while (i < n) {

            int k = 0;
            while (i<n && k<m) {
                if (s.charAt(i) == t.charAt(k)) {
                    k++;
                    if (k == m)  break;
                }
                i++;
            }

            if (k < m) break;

            int end = i;
            k = m-1;
            while (i >= 0) {
                if (s.charAt(i) == t.charAt(k)) {
                    k--;
                    if (k < 0) break;
                }
                i--;
            }

            int start = i;
            if (end-start+1 < ans) {
                ans = end-start+1;
                idx = start;
            }

            i = start+1;
        }

        if (ans == Integer.MAX_VALUE) return "";
        return s.substring(idx, idx + ans);
    }
}
