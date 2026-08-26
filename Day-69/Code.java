class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String res = "";

        int j = 0;
        int one = 0;
        int i = 0;
        while(i < n) {
            char c = s.charAt(i);
            if(c=='1') one++;

            while (one > k) {
                if (s.charAt(j) == '1') one--;
                j++;
            }

            if(one == k) {
                while (s.charAt(j) == '0') j++;

                int len = i-j+1;
                String curr = s.substring(j, i+1);

                if (res.isEmpty() 
                || curr.length() < res.length()
                || (curr.length() == res.length() && curr.compareTo(res) < 0)) {
                res = curr;
            }
            }
            i++;
        }

        return res;
    }
}
