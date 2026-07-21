class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        s = "1" + s + "1";

        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        int n = s.length();
        int i = 0;
        int ans = ones;
        while (i < n && s.charAt(i) == '1') i++;

        int initZeroes = 0;
        while (i < n && s.charAt(i) == '0') {
            initZeroes++;
            i++;
        }

        while (i < n) {
            int onesAfterZero = 0;
            while (i < n && s.charAt(i) == '1') {
                onesAfterZero++;
                i++;
            }

            if (onesAfterZero == 0) break;

            int zeroAfterOnes = 0;
            while (i < n && s.charAt(i) == '0') {
                zeroAfterOnes++;
                i++;
            }

            if (zeroAfterOnes == 0) break;

            ans = Math.max(ans, ones+initZeroes+zeroAfterOnes);

            initZeroes = zeroAfterOnes;
        }

        return ans;
    }
}
