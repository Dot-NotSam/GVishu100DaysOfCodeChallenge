class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int arr[] = new int[26];

        int j = 0;
        int maxFreq = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            arr[c-'A']++;

            maxFreq = Math.max(maxFreq, arr[c-'A']);
            while((i-j+1) - maxFreq > k){
                arr[s.charAt(j)-'A']--;
                j++;
            }

            ans = Math.max(ans, i-j+1);
        }
    
        return ans;
    }
}
