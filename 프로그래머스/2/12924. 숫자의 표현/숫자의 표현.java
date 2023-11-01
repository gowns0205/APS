import java.util.*;

class Solution {
    static int N;
    static int answer; 
    
    static void DFS(int cur, int sum){
        sum += cur;
        if(sum>N){
            return;
        }
        if(sum==N){
            answer++;
            return;
        }
        DFS(cur+1, sum);
    }
    
    public int solution(int n) {
        N = n;
        answer = 1;
        for(int start = 1; start <= n/2; start++){
            DFS(start, 0);
        }
        return answer;
    }
}