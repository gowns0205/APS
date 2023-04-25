import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        int size = record.length;
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String act = st.nextToken();
            String k = st.nextToken();
            if(act.equals("Leave"))
                continue;
            if(act.equals("Change"))
                size--;
            String v = st.nextToken();
            map.put(k,v);
        }
        String[] answer = new String[size];
        int idx = 0;
        for(int i=0; i<record.length; i++){
             StringTokenizer st = new StringTokenizer(record[i]);
            String act = st.nextToken();
            String k = st.nextToken();
            if(act.equals("Enter")){
                answer[idx] = map.get(k)+"님이 들어왔습니다.";
                idx++;
            } else if(act.equals("Leave")){
                answer[idx] = map.get(k)+"님이 나갔습니다.";
                idx++;
            } 
        }
        return answer;
    }
}