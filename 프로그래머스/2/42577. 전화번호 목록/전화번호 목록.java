import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 모든 부분문자열을 다 해시맵에 추가해서 검토하는것보다
        // 정렬 한 번 돌려서 바로 다음 인덱스랑만 비교하는게 빠르다
        // n=1,000,000 일때 약 nlogn = 2000만
        // 배열 길이 조심 
        Arrays.sort(phone_book);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length-1; i++){
           if(phone_book.length==1){
               answer = true;
               break;
           }
            // if(phone_book[i].equals(phone_book[i+1].substring(0,Math.min(phone_book[i+1].length(),phone_book[i].length())))){
            if(phone_book[i+1].startsWith(phone_book[i])){
               answer = false;
               break;
            }
        }
        return answer;
    }
}