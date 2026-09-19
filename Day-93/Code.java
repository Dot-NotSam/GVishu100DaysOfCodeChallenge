class Solution {
    public boolean checkOverlap(int r, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        int closeX = Math.max(x1, Math.min(xCenter, x2));
        int closeY = Math.max(y1, Math.min(yCenter, y2));

        int dx = xCenter-closeX;
        int dy = yCenter-closeY;

        if(dx*dx + dy*dy <= r*r) return true;
        return false;
    }
}
