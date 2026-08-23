

class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int num = n;
        while(num > 0) {
            int digit = num%10;
            sum += digit;
            prod *= digit;
            num /= 10;
        }

        int op = sum+prod;
        return n%op == 0;
    }
}
