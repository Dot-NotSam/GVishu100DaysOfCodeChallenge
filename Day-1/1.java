class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        
        long len = 0;
        for(char c : s.toCharArray()){
            if(c == '*') len = Math.max(len-1, 0L);
            else if (c == '#') len *= 2;
            else if (c != '%') len++;
        }

        if(k>=len) return '.';

        for(int i = n-1; i>=0; i--) {
            char c = s.charAt(i);

            if (c == '*') len++;
            else if(c == '#') {
                long half = len/2;
                if(k >= half) k -= half;
                len = half;
            } 
            else if (c == '%') k = len-1-k;
            else {
                if(k == len-1) return c;
                len--;
            }
        }

        return '.';
    }
}
