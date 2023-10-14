import java.util.*;
import java.io.*;

public class Main {
	static int[][] A;
	static int N;
	static int outSand;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] tx = { 
			{ -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 }, 
			{ -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 },
			{ -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 },
			{ 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 } 
			};
	
	static int[][] ty = { 
			{ 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 }, 
			{ -1, 1, 2, -2, 0, -1, 1, -1, 1, 0 },
			{ -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 }, 
			{ -1, 1, 2, -2, 0, -1, 1, -1, 1, 0 }
	};

	static int[] ratio = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int r = N / 2;
		int c = N / 2;
		int d = 0;
		int idx = 0;
		int turn = 1;
		int cntTwo = 0;
		// 토네이도 이동 
		while (r > 0 || c > 0) {
			moveTornado(r, c, d);
			r += dx[d];
			c += dy[d];
			idx++;
			// 현재 길이에서 두 번 이동했으면 방향전환 
			if (idx == turn) {
				d = (d + 1) % 4;
				idx = 0;
				cntTwo++;
			}
			if (cntTwo == 2) {
				turn++;
				cntTwo = 0;
			}
		}
		System.out.println(outSand);
	}

	static void moveTornado(int r, int c, int d) {
		int yr = r + dx[d];
		int yc = c + dy[d];
		int movedSand = 0;
		// a 제외
		for (int i = 0; i < 9; i++) {
			int tr = yr + tx[d][i];
			int tc = yc + ty[d][i];
			if (tr < 0 || tr > N - 1 || tc < 0 || tc > N - 1) {
				outSand += (A[yr][yc] * ratio[i]) / 100;
				movedSand += (A[yr][yc] * ratio[i]) / 100;
				continue;
			}
			A[tr][tc] += (A[yr][yc] * ratio[i]) / 100;
			movedSand += (A[yr][yc] * ratio[i]) / 100;
		}
		// a
		// a로 이동하는 모래 양은 비율이 적혀있는 칸으로 이동하지 않은 모래의 양 
		// 소수점 절사때문에 소실되는 모래는 없어야 함 
		int ar = yr + tx[d][9];
		int ac = yc + ty[d][9];
		if (ar < 0 || ar > N - 1 || ac < 0 || ac > N - 1) {
			outSand += A[yr][yc] - movedSand;
		} else {
			A[ar][ac] += A[yr][yc] - movedSand;
		}
		A[yr][yc] = 0;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (r == i && c == j)
//					System.out.print("x   ");
//				else if (yr == i && yc == j)
//					System.out.print("y   ");
//				else
//					System.out.print(A[i][j] + "   ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println("dir: " + d);
//		System.out.println("outSand: " + outSand);
//		System.out.println();
	}
}