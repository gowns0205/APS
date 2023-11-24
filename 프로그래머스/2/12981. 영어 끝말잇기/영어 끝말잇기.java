import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        boolean result = false;
        int idx = 0;
        int result_idx = 0;
        int num = 0;
        for(int i=0; i < words.length; i++) {
            idx = (idx+1)%(n+1);
            if(idx==0)
                idx = 1;
            map.put(words[i], map.getOrDefault(words[i],0)+1);
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                result_idx = idx;
                num = i+1;
                break;
            }
            if(map.get(words[i]) > 1) {
                result_idx = idx;
                num = i+1;
                break;
            }
        }
        num = (int) Math.ceil((double) num / n);
        System.out.println(num);
        if(num == 0 && result_idx != 0)
            num = 1;
        int[] answer = {result_idx, num};
        return answer;
    }
}