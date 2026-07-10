class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;

        int arr[] = new int[26];
        int arr2[] = new int[26];

        for(char c : s1.toCharArray()) {
            arr[c-'a']++;
        }

        int j = 0;
        int curr = 0;
        for(int i = 0; i < m; i++) {
            char c = s2.charAt(i);

            if(i < n) {
                arr2[c-'a']++;
            } else {
                arr2[c-'a']++;
                arr2[s2.charAt(j)-'a']--;
                j++;
            }

            if (i >= n-1) {
                if (Arrays.equals(arr, arr2))
                    return true;
            }
        }

        return false;
    }
}
