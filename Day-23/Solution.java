class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] newArr = new int[n];    

        for(int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }

        Arrays.sort(newArr);

        int rank = 1;
        for(int num : newArr) {
            if(!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}
