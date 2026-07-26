class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        int a = -1001;
        int b = -1001;
        int c = -1001;

        int x = 0;
        int y = 0;

        int i = 0;
        while(i < n) {
            int num = nums[i];

            if(a <= num) {
                c = b;
                b = a;
                a = num;
            } else if (b <= num) {
                c = b;
                b = num;
            } else if (c < num) {
                c = num;
            }

            if(x >= num) {
                y = x;
                x = num;
            } else if (y >= num) {
                y = num;
            }

            i++;
        }

        return Math.max(x*y*a, a*b*c);
    }
}
