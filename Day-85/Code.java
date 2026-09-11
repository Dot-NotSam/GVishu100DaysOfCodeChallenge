class Solution {
    int cnt = 0;

    public int totalNumbers(int[] digits) {
        int n = digits.length;
        boolean[] visited = new boolean[n];
        func(digits, n, new StringBuilder(), visited);
        return cnt;
    }

    public void func(int[] arr, int n, StringBuilder num,
                     boolean[] visited) {

        if (num.length() == 3) {
            if (Integer.parseInt(num.toString())%2 == 0) {
                cnt++;
            }
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            if (set.contains(arr[i])) continue;
            set.add(arr[i]);

            if (num.length() == 0 && arr[i] == 0) continue;

            visited[i] = true;
            num.append(arr[i]);
            func(arr, n, num, visited);
            num.deleteCharAt(num.length()-1);
            visited[i] = false;
        }
    }
}
