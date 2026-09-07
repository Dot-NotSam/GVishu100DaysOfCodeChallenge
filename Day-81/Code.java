class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int i = 0;
        int j = 0;
        int ans = 0;
        int[] arr = new int[3];

        while(i < n) {
            char c = s.charAt(i);
            arr[c-'a']++;
            
            while (arr[0] > 0 && 
                   arr[1] > 0 && 
                   arr[2] > 0
            ){
                ans += (n-i);
                arr[s.charAt(j) - 'a']--;
                j++;
            }    

            i++;
        }

        return ans;
    }
}
