class Solution {
    public int maxProduct(int[] nums) {
        int a = 1;
        int b = 1;

        for(int num : nums){
            if(a <= num){
                b = a;
                a = num;
            }
            else if(b <= num){
                b = num;
            }
        }

        return (a-1)*(b-1);
    }
}
