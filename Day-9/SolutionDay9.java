class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int left = 0;
        int right = n-1;

        while(left < right) {
            int dist = right-left;
            int area = 0;
            
            if(height[left] < height[right]) {
                area = height[left]*dist;
                left++;
            }
            else {
                area = height[right]*dist;
                right--;
            }

            res = Math.max(area, res); 
        }

        return res;
    }
}
