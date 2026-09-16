import java.math.BigInteger;
class Solution {
    public int numberOfSets(int n, int k) {
        int N = n+k-1;
        int R = 2*k;

        BigInteger ans = BigInteger.ONE;

        for (int i = 1; i <= R; i++) {
            ans = ans.multiply(BigInteger.valueOf(N-R+i));
            ans = ans.divide(BigInteger.valueOf(i));
        }

        return ans.mod(BigInteger.valueOf(1_000_000_007)).intValue();
    }
}
