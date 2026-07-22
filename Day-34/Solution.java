class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                while(!st.isEmpty() && st.peek() > 0 && 
                Math.abs(asteroids[i]) > st.peek()) 
                {
                    st.pop();
                }

                if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                }

                else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }

        int sz = st.size();
        int[] arr = new int[sz];
        for(int i = sz-1; i >= 0; i--) {
            arr[i] = st.pop();
        }

        return arr;
    }
}
