import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] A;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int minTime = Integer.MAX_VALUE;
	static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스 개수
		A = new int[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == 2)
					list.add(new Node(i, j));
			}
		}
		boolean[] visited = new boolean[list.size()];
		combination(M, 0, 0, visited);
		if (minTime < 10000)
			System.out.println(minTime);
		else
			System.out.println(-1);
	}

	static void combination(int r, int depth, int start, boolean[] visited) {
		if (depth == r) {
			Node[] virus = new Node[r];
			int idx = 0;
			for (int i = 0; i < list.size(); i++) {
				if (visited[i]) {
					virus[idx] = list.get(i);
					idx++;
				}
			}
			BFS(virus);
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

	static void BFS(Node[] virus) {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] == 1)
					map[i][j] = -1; // 벽
				else
					map[i][j] = -2; // 빈칸
			}
		}
		for (int i = 0; i < M; i++) {
			Node cur = virus[i];
			map[cur.r][cur.c] = 0; // 바이러스 시작 위치를 0으로 표시
		}
		int curTime = 0;
		while (true) {
			boolean isUpdate = false;
			Queue<Node> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == curTime) {
						for (int d = 0; d < 4; d++) {
							int dr = i + dx[d];
							int dc = j + dy[d];
							if (dr < 0 || dr > N - 1 || dc < 0 || dc > N - 1)
								continue;
							if (map[dr][dc] == -2) {
								isUpdate = true;
								map[dr][dc] = curTime + 1;
							}
						}
					}
				}
			}
			curTime++;
			if (countZero(map)) {
				// 바이러스 배치하자마자 끝난 경우
				if (!isUpdate)
					curTime--;
				if (curTime < minTime)
					minTime = curTime;
				break;
			} else {
				// 벽에 막혀서 업데이트 안되는 경우
				if (!isUpdate) {
					break;
				}
			}
		}
	}

	static boolean countZero(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -2)
					count++;
			}
		}
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}