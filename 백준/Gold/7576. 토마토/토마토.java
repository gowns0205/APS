import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer MN = new StringTokenizer(br.readLine());
		M = Integer.parseInt(MN.nextToken());
		N = Integer.parseInt(MN.nextToken());
		map = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) queue.add(new int[] {i, j});
			}
		}
		
		if (check()) sb.append(0);
		else {
			int day = -1;
			while (!queue.isEmpty()) {
				day++;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int[] cur = queue.poll();
					for (int k = 0; k < 4; k++) {
						int nr = cur[0] + dr[k];
						int nc = cur[1] + dc[k];
						if (inBnd(nr, nc) && map[nr][nc] == 0) {
							map[nr][nc] = 1;
							queue.add(new int[] {nr, nc});
						}
					}
				}
			}
			if (check()) sb.append(day);
			else sb.append(-1);
		}
		System.out.println(sb);
	}
	
	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	private static boolean inBnd(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
}