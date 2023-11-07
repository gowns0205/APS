import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dis;
    
    static void BFS(int[][] maps){
        int n = maps.length;
        int m = maps[n-1].length;
        dis = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        dis[0][0] = 1;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            // BFS니까 맨 처음 도착하는 노드가 최단경로 타고 왔다. 
            if(cur.r==n-1 && cur.c == m-1){
                return;
            }
            for(int i=0; i<4; i++){
                int dr = cur.r + dx[i];
                int dc = cur.c + dy[i];
                // n, m 실수하지 말자...
                if(dr<0 || dr> n-1 || dc<0 || dc>m-1)
                    continue;
                if(maps[dr][dc]==1 && dis[dr][dc]==0){
                    queue.add(new Node(dr,dc));
                    dis[dr][dc] = dis[cur.r][cur.c] + 1;
                }
            }
        }
    }   
    
    public int solution(int[][] maps) {
        BFS(maps);
        int n = maps.length;
        int m = maps[n-1].length;
        if(dis[n-1][m-1]==0)
            return -1;
        else
            return dis[n-1][m-1];
    }
    
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}