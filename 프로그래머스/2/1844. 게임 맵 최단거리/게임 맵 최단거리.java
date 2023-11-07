import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static void BFS(int[][] maps){
        int n = maps.length;
        int m = maps[n-1].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1));
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.r==n-1 && cur.c == m-1){
                if(cur.depth<min)
                    min = cur.depth;
            }
            for(int i=0; i<4; i++){
                int dr = cur.r + dx[i];
                int dc = cur.c + dy[i];
                if(dr<0 || dr> n-1 || dc<0 || dc>m-1)
                    continue;
                if(!visited[dr][dc] && maps[dr][dc]==1){
                    visited[dr][dc] = true;
                    queue.add(new Node(dr,dc,cur.depth+1));
                }
            }
        }
}   
    
    public int solution(int[][] maps) {
        BFS(maps);
        if(min>10000)
            return -1;
        else
            return min;
    }
    

    
    static class Node {
        int r, c, depth;
        Node(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}