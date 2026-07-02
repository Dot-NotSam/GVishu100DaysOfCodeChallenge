class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int i = 0;
        int j = n-1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                char smol = (char) Math.min(arr[i], arr[j]);
                arr[i] = smol;
                arr[j] = smol;
            }

            i++;
            j--;
        }

        return new String(arr);
    }
}
