class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;
        for(int h=3; h<size; h++){
            int w = size / h;
            if(w*h != size)
                continue;
            if((w-2)*(h-2)==yellow){
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        return answer;
    }
}