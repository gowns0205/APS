import java.util.*;
import java.io.*;

public class Main {

	static int[][] A;
	static int N;
	static int M;
	static ArrayList<Node> list;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int minDis = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == 2) {
					list.add(new Node(i, j));
				}
			}
		}
		boolean[] visited = new boolean[list.size()];
		combination(M, 0, 0, visited);
		System.out.println(minDis);
	}

	static void combination(int r, int depth, int start, boolean[] visited) {
		if (depth == r) {
			Node[] remain = new Node[r]; // 조합으로 뽑은 살아남은 치킨집 배열
			int idx = 0;
			for (int i = 0; i < list.size(); i++) {
				if (visited[i]) {
					remain[idx] = list.get(i);
					idx++;
				}
			}
			BFS(remain);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(r, depth + 1, i + 1, visited);
				visited[i] = false;
			}
		}

	}

	static void BFS(Node[] remain) {
		int[][] map = new int[N][N];
		int totalDis = 0; // 현재 도시의 치킨거리 sum
		for (int i = 0; i < N; i++) {
			map[i] = A[i].clone();
		}
		for (int i = 0; i < M; i++) {
			int r = remain[i].r;
			int c = remain[i].c;
			map[r][c] = 3; // 살아남은 치킨집은 3으로 표시
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					boolean[][] visited = new boolean[N][N];
					Queue<Node> queue = new LinkedList<>();
					queue.add(new Node(r, c));
					while (!queue.isEmpty()) {
						Node cur = queue.poll();
						if (map[cur.r][cur.c] == 3) {
							int curDis = getDistance(r, c, cur.r, cur.c);
							totalDis += curDis;
							break;
						}
						for (int d = 0; d < 4; d++) {
							int dr = cur.r + dx[d];
							int dc = cur.c + dy[d];
							if (dr < 0 || dr > N - 1 || dc < 0 || dc > N - 1)
								continue;
							if (!visited[dr][dc]) {
								visited[dr][dc] = true;
								queue.add(new Node(dr, dc));
							}
						}
					}
				}
			}
		}
		if (totalDis < minDis)
			minDis = totalDis;
	}

	static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}