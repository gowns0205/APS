import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length-1; i++){
           if(phone_book.length==1){
               answer = true;
               break;
           }
            if(phone_book[i].equals(phone_book[i+1].substring(0,Math.min(phone_book[i+1].length(),phone_book[i].length())))){
               answer = false;
               break;
            }
        }
        return answer;
    }
}