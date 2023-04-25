class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int users = stages.length;
        double[] rateArr = new double[N];
        for(int i=1; i<=N; i++){ //스테이지
            int curUser = 0;
            double rate = 0;
            for(int j=0; j<stages.length; j++){
                if(stages[j]==i){
                    curUser++;
                }
            }
            rate = (double) curUser/users;
            users -= curUser;
            rateArr[i-1] = rate;
        }
        for(int i=0; i<N; i++){
            answer[i] = i+1;
        }
        for(int i=0; i<N; i++){
            int tmp_stage = 0;
            double tmp_value =0;
            for(int j=i+1; j<N; j++){
                if(rateArr[j]>rateArr[i]){
                    tmp_stage = answer[i];
                    tmp_value = rateArr[i];
                    answer[i] = answer[j];
                    rateArr[i] = rateArr[j];
                    answer[j] = tmp_stage;
                    rateArr[j] = tmp_value;
                }
            }
        }
        
        for(int i=0; i<N; i++){
            int tmp_stage = 0;
            double tmp_value =0;
            for(int j=i+1; j<N; j++){
                if(rateArr[j]==rateArr[i] && answer[i]>answer[j]){
                    tmp_stage = answer[i];
                    tmp_value = rateArr[i];
                    answer[i] = answer[j];
                    rateArr[i] = rateArr[j];
                    answer[j] = tmp_stage;
                    rateArr[j] = tmp_value;
                }
            }
        }
        return answer;
    }
}