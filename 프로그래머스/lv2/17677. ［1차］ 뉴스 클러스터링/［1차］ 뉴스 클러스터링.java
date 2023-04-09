import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for(int i=0; i<str1.length()-1; i++){
            if((str1.charAt(i)>='A'&&str1.charAt(i)<='Z')||(str1.charAt(i)>='a'&&str1.charAt(i)<='z')){
                if((str1.charAt(i+1)>='A'&&str1.charAt(i+1)<='Z')||(str1.charAt(i+1)>='a'&&str1.charAt(i+1)<='z')){
                String s = String.valueOf(str1.charAt(i))+String.valueOf(str1.charAt(i+1));
                s = s.toUpperCase();
                list1.add(s);
                }
            } 
        }
         for(int i=0; i<str2.length()-1; i++){
            if((str2.charAt(i)>='A'&&str2.charAt(i)<='Z')||(str2.charAt(i)>='a'&&str2.charAt(i)<='z')){
                if((str2.charAt(i+1)>='A'&&str2.charAt(i+1)<='Z')||(str2.charAt(i+1)>='a'&&str2.charAt(i+1)<='z')){
                String s = String.valueOf(str2.charAt(i))+String.valueOf(str2.charAt(i+1));
                s = s.toUpperCase();
                list2.add(s);
                }
            } 
        }
        int intersection=0;
        boolean[] visited = new boolean[list2.size()];
        for(int i=0; i<list1.size(); i++){ 
            for(int j=0; j<list2.size(); j++){
                if(!visited[j]&&list1.get(i).equals(list2.get(j))){
                    visited[j] =true;
                    intersection++;
                    break;
            }
            }
        }
        int union = list1.size() + list2.size() - intersection;
        double result=0;
        if(list1.size()==0 && list2.size()==0){
             result =1;
        } else{
            result = (double)intersection/union;
        }
        result *= 65536;
        answer = (int)Math.floor(result);
        System.out.println(answer);
        return answer;
    }
}