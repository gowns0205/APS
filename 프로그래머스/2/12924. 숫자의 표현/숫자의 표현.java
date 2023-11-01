import java.util.*;

// 어떤 자연수를 연속된 수의 합으로 표현하는 방법의 수와, 해당 자연수의 홀수 약수 개수는 같다. 
class Solution {
    
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i+=2){
            if(n%i==0)
                answer++;
        }
        return answer;
    }
}