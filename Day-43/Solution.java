class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c-'a']++;
        }

        Arrays.sort(arr);

        int ans = 0;
        for (int i = 25; i >= 0 && arr[i] > 0; i--) {
            if(i >= 18) ans += arr[i];
            else if(i >= 10) ans += 2*arr[i];
            else if(i >= 2) ans += 3*arr[i];
            else ans += 4*arr[i];
        }

        return ans;
    }
}
