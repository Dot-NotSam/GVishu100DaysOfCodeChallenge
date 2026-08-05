class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(char c : num.toCharArray()) {
            while(!st.isEmpty() && st.peek()>c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while(k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String ans = sb.substring(i);
        return ans.isEmpty() ? "0" : ans;
    }
}
