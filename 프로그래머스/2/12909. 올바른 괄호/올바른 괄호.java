import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // String[] arr = s.split("");
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur=='('){
                stack.push('(');
            } 
            if(cur==')'){
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                if(stack.peek()=='('){
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
             answer = false;
        return answer;
    }
}