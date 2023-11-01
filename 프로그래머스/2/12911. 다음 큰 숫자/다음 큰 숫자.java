class Solution {
    public int solution(int n) {
        int start = Integer.bitCount(n);
        while(true){
            n++;
            if(start==Integer.bitCount(n))
                break;
        }
        return n;
    }
}