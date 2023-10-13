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
		A = new Queue[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				A[r][c] = new LinkedList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			// 파이어볼 초기 배치
			queue.add(new FireBall(r, c, m, s, d));
		}
		for (int i = 0; i < K; i++) {
			moveFireBall();
		}
		long result = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
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
			// 인덱스를 1~N으로 사용하면 0에 대한 예외처리 필요
			int dr = (N  + cur.r + dx[cur.d] * (cur.s % N)) % N;
			int dc = (N  + cur.c + dy[cur.d] * (cur.s % N)) % N;
			// 새로운 위치에 파이어볼 재배치
			A[dr][dc].add(new FireBall(dr, dc, cur.m, cur.s, cur.d));
		}
		combineAndDivideFireBall();
	}

	static void combineAndDivideFireBall() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 파이어볼 2개 이상 위치한 칸에서는 합침&분열 발생
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
					// 질량 0인 파이어볼은 소멸
					if (dm == 0)
						continue;
					for (int i = 0; i < 4; i++) {
						// 파이어볼 방향이 모두 홀수거나 모두 짝수
						if (!isOdd || !isEven) {
							queue.add(new FireBall(r, c, dm, ds, i * 2));
						}
						// 홀,짝 섞여있을 경우
						if (isOdd && isEven) {
							queue.add(new FireBall(r, c, dm, ds, i * 2 + 1));
						}
					}
				}
				// 2개 미만인 칸에서는 그냥 재배치
				else {
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

		int r, c, m, d, s;

		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}