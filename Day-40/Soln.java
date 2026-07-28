class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] count = new int[26];

        for (int i = 0; i < n/2; i++) {
            char ch = arr[i];
            count[ch-'a']++;
        }

        int idx = 0;

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {

                char ch = (char) ('a'+i);

                arr[idx] = ch;
                arr[n-1-idx] = ch;

                idx++;
                count[i]--;
            }
        }

        return new String(arr);
    }
}
