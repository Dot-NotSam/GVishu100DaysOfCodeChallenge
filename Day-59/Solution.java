class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i <= n; i++) {
            int curr;
            if (i == n) curr = 0;
            else curr = heights[i];

            while(!st.isEmpty() && heights[st.peek()] > curr) {
                int ht = heights[st.pop()];
                int wt;

                if(st.isEmpty()) wt = i;
                else {wt = i-st.peek()-1;}

                res = Math.max(res, ht*wt);
            }
            st.push(i);
        }

        return res;
    }
}
