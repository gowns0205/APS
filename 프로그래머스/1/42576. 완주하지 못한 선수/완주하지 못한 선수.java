import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<participant.length; i++){
            if(i==completion.length||!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
    
    // public String solution(String[] participant, String[] completion) {
    //     String answer = "";
    //     Map<String,Integer> map = new HashMap<>();
    //     for(String p:participant){
    //         map.put(p,map.getOrDefault(p,0)+1);
    //     }
    //     for(String c:completion){
    //         map.put(c,map.get(c)-1);
    //     }
    //     for(String key: map.keySet()){
    //         if(map.get(key)!=0){
    //             answer = key;
    //             break;
    //         }
    //     }
    //     return answer;
    // }
    

}