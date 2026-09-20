class Solution {
    public int reverseDegree(String s) {
        s.toLowerCase();
        
        int sum = 0;
        int i = 1;
        for(char c : s.toCharArray()) {
            char z = 'z';
            int ascii = z-c+1;

            int product = ascii*i;
            sum += product;
            i++;
        }

        return sum;
    }
}
