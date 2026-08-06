class Solution {
    public int smallestNumber(int n, int t) {
        int ans = 0;
        while(ans==0) {
            int prod = 1;
            int num = n;
            while(n != 0) {
                prod *= n%10;
                n/=10;
            }
            n = num;

            if(prod%t==0) {
                ans = num;
                break;
            }
            n++;
        }

        return ans;
    }
}
