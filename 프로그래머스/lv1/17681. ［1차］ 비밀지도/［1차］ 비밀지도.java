class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] result = new int[n][n];
        for(int i=0; i<n; i++){
            String s1 = Integer.toString(arr1[i],2);
            String s2 = Integer.toString(arr2[i],2);
            for(int j=0; j<s1.length(); j++){
                result[i][n-s1.length()+j] += s1.charAt(j) - '0';
            }
            for(int j=0; j<s2.length(); j++){
                result[i][n-s2.length()+j] += s2.charAt(j) - '0';
            }
        }
        for(int i=0; i<n; i++){
            String s = "";
            for(int j=0; j<n; j++){
                if(result[i][j]==0)
                    s += " ";
                else
                    s += "#";
            }
            answer[i] = s;
        }
        return answer;
    }
}