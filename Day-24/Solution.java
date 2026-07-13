class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";

        int l = String.valueOf(low).length();
        int h = String.valueOf(high).length();

        for (int op = l; op <= h; op++) {
            for (int i = 0; i <= 9-op; i++) {
                String curr = digits.substring(i, i+op);
                int num = Integer.parseInt(curr);

                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        return result;
    }
}
