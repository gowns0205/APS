import java.util.*;
import java.io.*;

class Solution {
    static long[] dp;
    
    public int solution(int n) {
        int answer = 0;
        dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        // for문 풀이
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return (int) dp[n];
    }
    
    // 재귀, 메모이제이션
    static long pibo(int cur){
        if(cur<=0)
            return 0;
        if(cur==1)
            return 1;
        if(dp[cur]!=0)
            return dp[cur];
        dp[cur] = (pibo(cur-1) + pibo(cur-2)) % 1234567;
        return dp[cur];
    }
}