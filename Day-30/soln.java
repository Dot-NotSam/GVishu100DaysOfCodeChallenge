class Solution {
    public int GCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return GCD(b, a%b);
    }

    public int findGCD(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }

        return GCD(max, min);
    }
}
