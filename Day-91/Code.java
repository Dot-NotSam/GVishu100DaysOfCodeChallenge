class Solution {
    public int isPrefixOfWord(String sent, String sW) {
        int n = sent.length();

        int j = 0;
        int word = 1;
        for (int i = 0; i < n; i++) {
            if (sent.charAt(i) == ' ') {
                j = i+1;
                word++;
                continue;
            }

            if (i-j+1 == sW.length()) {
                if (sent.substring(j, i+1).equals(sW)) {
                    return word;
                }
            }
        }

        if (n-j >= sW.length()) {
            if (sent.substring(j, j+sW.length()).equals(sW)) {
                return word;
            }
        }

        return -1;
    }
}
