class Solution {
    static int[] dx = {0,1,1};
    static int[] dy = {1,0,1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                map[r][c] = board[r].charAt(c);
            }
        }
        while(true){
            boolean[][] check = new boolean[m][n];
            boolean change = false;
            for(int r=0; r<m-1; r++){
                for(int c=0; c<n-1; c++){
                    if(map[r][c]=='0')
                        continue;
                    int cnt = 1;
                    for(int d=0; d<3; d++){
                        int dr = r + dx[d];
                        int dc = c + dy[d];
                        if(dr>m-1||dc>n-1)
                            continue;
                        if(map[dr][dc]==map[r][c])
                            cnt++;
                    }
                    if(cnt==4){
                        change = true;
                        check[r][c] = true;
                        for(int d=0; d<3; d++){
                            int dr = r + dx[d];
                            int dc = c + dy[d];
                            check[dr][dc] = true;
                        }
                    }
                }
            }
            if(!change)
                break;
            char[][] move = new char[m][n];
            for(int c=0; c<n; c++){
                int idx = m-1;
                for(int r=m-1; r>=0; r--){
                    if(!check[r][c]){
                        move[idx][c] = map[r][c];
                        idx--;
                    }else
                        answer++;
                }
                 for(int r=0; r<=idx; r++){
                    move[r][c] = '0';
                }
            }
            for(int r=0; r<m; r++){
                for(int c=0; c<n; c++){
                    map[r][c] = move[r][c];
                }
            }
        }
        return answer;
    }
}