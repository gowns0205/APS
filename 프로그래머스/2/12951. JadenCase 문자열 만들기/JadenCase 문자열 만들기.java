import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        boolean flag = true;
        for(String ss : arr){
            answer += flag? ss.toUpperCase() : ss.toLowerCase();
            flag = ss.equals(" ")? true : false;
        }
        return answer;
    }
}