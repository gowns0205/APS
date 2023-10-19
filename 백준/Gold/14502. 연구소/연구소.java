import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] A;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited = new boolean[N * M];
		combination(3, 0, 0, visited);
		System.out.println(result);
	}

	static void combination(int r, int depth, int start, boolean[] visited) {
		if (depth == r) {
			int[] wall = new int[3];
			int idx = 0;
			for (int i = 0; i < N * M; i++) {
				if (visited[i]) {
					wall[idx] = i;
					idx++;
				}
			}
			BFS(wall);
			return;
		}
		for (int i = start; i < N * M; i++) {
			int dr = i / M;
			int dc = i % M;
			if (!visited[i] && A[dr][dc] == 0) {
				visited[i] = true;
				combination(3, depth + 1, i + 1, visited);
				visited[i] = false;
			}
		}
	}

	static void BFS(int[] wall) {
		int[][] map = new int[N][M];
		// 2차원배열 복사할땐 행 별로
		for (int i = 0; i < N; i++) {
			map[i] = A[i].clone();
		}
		for (int i = 0; i < 3; i++) {
			int dr = wall[i] / M;
			int dc = wall[i] % M;
			map[dr][dc] = 7;
		}
		boolean[][] visited = new boolean[N][M];
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 2) {
					queue.add(new Node(i, j));
					while (!queue.isEmpty()) {
						Node cur = queue.poll();
						for (int d = 0; d < 4; d++) {
							int dr = cur.r + dx[d];
							int dc = cur.c + dy[d];
							if (dr < 0 || dr > N - 1 || dc < 0 || dc > M - 1)
								continue;
							if (!visited[dr][dc] && map[dr][dc] == 0) {
								visited[dr][dc] = true;
								map[dr][dc] = 2;
								queue.add(new Node(dr, dc));
							}
						}
					}
				}
			}
		}
		countSafetyZone(map);
	}

	static void countSafetyZone(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}
		if (result < count)
			result = count;
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}