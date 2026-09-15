class Solution {
    public int kDistinctChar(String s, int k) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int ans = 0;

        while(i < n) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);


            while(j <= i && map.size()>k) {
                char ch = s.charAt(j);
                map.put(ch, map.get(ch)-1);

                if(map.get(ch) == 0) {
                    map.remove(ch);
                }
                j++;
            }

            ans = Math.max(ans, i-j+1);
            i++;
        }

        return ans;
    }
}
