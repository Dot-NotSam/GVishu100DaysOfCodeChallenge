class Solution {
    public int minBishopMoves(int[] sc, int[] tc) {
        if((sc[0]+sc[1])%2==0 && (tc[0]+tc[1])%2!=0) return -1;
        if((sc[0]+sc[1])%2!=0 && (tc[0]+tc[1])%2==0) return -1;

        if(sc[0]+sc[1] == tc[0]+tc[1]) return 1;
        if(sc[1]-sc[0] == tc[1]-tc[0]) return 1;

        return 2;
    }
}
