import java.util.*;
import java.io.*;

public class Main {
	static Queue<FireBall> queue;
	static Queue<FireBall>[][] A;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		A = new Queue[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				A[r][c] = new LinkedList<>();
			}
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			queue.add(new FireBall(r, c, m, s, d));
		}
		for (int i = 1; i <= K; i++) {
			moveFireBall();
		}
		long result = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				while (!queue.isEmpty()) {
					FireBall f = queue.poll();
					result += f.m;
				}
			}
		}
		System.out.println(result);
	}

	static void moveFireBall() {
		while (!queue.isEmpty()) {
			FireBall cur = queue.poll();
			int dr = (cur.r + dx[cur.d] * cur.s) % N;
			int dc = (cur.c + dy[cur.d] * cur.s) % N;
			if (dr <= 0)
				dr = N + dr;
			if (dc <= 0)
				dc = N + dc;
			A[dr][dc].add(new FireBall(dr, dc, cur.m, cur.s, cur.d));
		}
		combineAndDivideFireBall();
	}

	static void combineAndDivideFireBall() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (A[r][c].size() >= 2) {
					int size = A[r][c].size();
					boolean isOdd = false;
					boolean isEven = false;
					int dm = 0;
					int ds = 0;
					while (!A[r][c].isEmpty()) {
						FireBall f = A[r][c].poll();
						dm += f.m;
						ds += f.s;
						if (f.d % 2 != 0)
							isOdd = true;
						if (f.d % 2 == 0)
							isEven = true;
					}
					dm /= 5;
					ds /= size;
					if (dm == 0)
						continue;
					for (int i = 0; i < 4; i++) {
						if (!isOdd || !isEven) {
							queue.add(new FireBall(r, c, dm, ds, i * 2));
						}
						if (isOdd && isEven) {
							queue.add(new FireBall(r, c, dm, ds, i * 2 + 1));
						}
					}
				} else {
					while (!A[r][c].isEmpty()) {
						FireBall f = A[r][c].poll();
						if (f.m == 0)
							continue;
						queue.add(f);
					}
				}
			}
		}
	}

	static class FireBall {
		int r;
		int c;
		int m; // 질량
		int s; // 이동거리
		int d; // 방향

		FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}