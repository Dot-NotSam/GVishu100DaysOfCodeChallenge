class Solution {
    TreeSet<String> ans = new TreeSet<>();

    public List<String> braceExpansionII(String exp) {
        func(exp);
        return new ArrayList<>(ans);
    }

    public void func(String s) {
        int r = s.indexOf('}');
        if (r == -1) {
            ans.add(s);
            return;
        }

        int l = s.lastIndexOf('{', r);

        String left = s.substring(0, l);
        String right = s.substring(r+1);
        String in = s.substring(l+1, r);

        for (String p : in.split(",")) {
            func(left + p + right);
        }
    }
}
