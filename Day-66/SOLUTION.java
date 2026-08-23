class Solution {
    public boolean sumGame(String s) {
        int n = s.length();
        int sum1 = 0;
        int sum2 = 0;
        int qm1 = 0;
        int qm2 = 0;

        for(int i = 0; i < n; i++) {    
            char c = s.charAt(i);
            int dig = c-'0';

            if (c == '?') {
                if (i < n/2) qm1++;
                else qm2++;
            } else {
                if (i < n/2) sum1 += dig;
                else sum2 += dig;
            }
        }

        if((qm1+qm2)%2!=0) return true;

        return sum1-sum2 != 9*(qm2-qm1)/2;

    }
}
