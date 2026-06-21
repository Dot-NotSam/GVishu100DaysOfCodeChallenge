class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for(int i: costs) max = Math.max(i, max);

        int[] arr = new int[max+1];
        for(int i = 0; i < costs.length; i++) arr[costs[i]]++;

        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) continue;

            if (i*arr[i] <= coins) {
                ans += arr[i];
                coins -= i*arr[i];
            } else {
                return ans + (coins/i);
            }
        }

        return ans;
    }
}
