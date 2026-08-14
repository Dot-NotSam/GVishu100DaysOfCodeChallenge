class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] arr = new int[26];

        int j = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i)-'a';

            while (arr[idx] == 2) {
                arr[s.charAt(j)-'a']--;
                j++;
            }

            arr[idx]++;
            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }
}
