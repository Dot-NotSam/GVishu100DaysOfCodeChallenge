class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] prev = new int[n];
        int[] next = new int[n];

        findPSEE(arr, prev);
        findNSE(arr, next);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            ans = (ans + (arr[i]*left*right)%MOD)%MOD;
        }

        return (int) ans;
    }

    public void findPSEE(int[] arr, int[] prev) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public void findNSE(int[] arr, int[] next) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }
}
