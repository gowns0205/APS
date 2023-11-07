import java.util.*;

class Solution {
    
    static int N;
    static int answer;
    
    static void DFS(int depth, int[] numbers, int sum, int target){
        if(depth==N){
            if(sum==target)
                answer++;
            return;
        }
        DFS(depth+1, numbers, sum + numbers[depth], target);
        DFS(depth+1, numbers, sum - numbers[depth], target);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        DFS(0, numbers, 0, target);
        return answer;
    }

}