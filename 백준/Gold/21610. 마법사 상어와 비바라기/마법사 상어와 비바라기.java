import java.util.*;
import java.io.*;

public class Main {
	static int[][] A;
	static int N;
	static Queue<Cloud> queue; // 구름을 담는 큐
	static Queue<Cloud> copy; // 물복사 위치를 담는 큐
	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }; // 행
	static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 }; // 열
	static int[] cross_r = { 0, -1, -1, 1, 1 };
	static int[] cross_c = { 0, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		queue = new LinkedList<>();
		copy = new LinkedList<>();
		firstCloud();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			moveCloud(d, s);
		}
		int totalWater = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				totalWater += A[r][c];
			}
		}
		System.out.println(totalWater);
	}

	// 구름 초기 생성
	static void firstCloud() {
		queue.add(new Cloud(N, 1));
		queue.add(new Cloud(N, 2));
		queue.add(new Cloud(N - 1, 1));
		queue.add(new Cloud(N - 1, 2));
	}

	// 구름을 이동시키는 메서드
	static void moveCloud(int d, int s) {
		boolean[][] visited = new boolean[N + 1][N + 1];
		// 구름을 d방향으로 s칸 만큼 이동
		while (!queue.isEmpty()) {
			Cloud cur = queue.poll();
			int dr = (cur.r + dx[d] * s) % N;
			int dc = (cur.c + dy[d] * s) % N;
			if (dr <= 0)
				dr = N + dr;
			if (dc <= 0)
				dc = N + dc;
			// 구름 위치한칸에 1만큼 비내리기
			A[dr][dc] += 1;
			visited[dr][dc] = true;
			copy.add(new Cloud(dr, dc));
		}
		waterCopyBugMagic();
		makeCloud(visited);
	}

	static void waterCopyBugMagic() {
		while (!copy.isEmpty()) {
			Cloud cur = copy.poll();
			for (int i = 1; i <= 4; i++) {
				int cr = cur.r + cross_r[i];
				int cc = cur.c + cross_c[i];
				if (cr < 1 || cc < 1 || cr > N || cc > N) {
					continue;
				}
				// 대각선 방향에 물 위치한 수 만큼 현재 위치 물 증가
				if (A[cr][cc] > 0)
					A[cur.r][cur.c]++;
			}
		}
	}

	static void makeCloud(boolean[][] visited) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (!visited[r][c] && A[r][c] >= 2) {
					queue.add(new Cloud(r, c));
					A[r][c] -= 2;
				}
			}
		}
	}

	static class Cloud {
		int r;
		int c;

		Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}