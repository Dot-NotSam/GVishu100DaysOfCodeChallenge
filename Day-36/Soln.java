class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] prev = new int[n];
        int[] next = new int[n];

        findPSE(arr, prev);
        findNSE(arr, next);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            ans += arr[i]*left*right;
        }

        return ans;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;

        int[] prev = findPGE(arr);
        int[] next = findNGE(arr);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            ans += arr[i]*left*right;
        }

        return ans;
    }


    public void findPSE(int[] arr, int[] prev) {
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

    private int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    private int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }
}
