class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String curr = new String(c);

            if(!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }

            map.get(curr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
