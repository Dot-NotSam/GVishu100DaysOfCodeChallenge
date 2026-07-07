class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        long pow = 1;
        long sum = 0;
        
        while(n > 0) {
            int digit = n%10;

            if(digit != 0) {
                sum += digit;
                num += digit*pow;
                pow *= 10;
            }

            n /= 10;
        }

        return num*sum;
    }
}
