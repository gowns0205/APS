import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String MN = br.readLine();
		StringTokenizer st = new StringTokenizer(MN);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] chessBoard = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				chessBoard[i][j] = s.charAt(j);
			}
		}
		int minCnt = 10000;
		int idx = 0;
		
		int tmpMin = 0;
		// 인덱스 실수.. N-8이 아니라 N-7을 해야 끝까지 조회할 수 있다.
		// 뭔가 안될땐 출력해보자.
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				//처음에 B, W를 경우의수를 직접 정해주면 안된다. (ex chessBoard[i][j]='B')
				//두개 다 돌려서 그 중 최소값을 알아서 고르게 해야한다. 
				//입력된 체스판에 맞춰야하기 때문이다. 
				int case1 = 0;
				int case2 = 0;
				for (int r = i; r < i + 8; r++) {
					for (int c = j; c < j + 8; c++) {
						if (((r - i) + (c - j)) % 2 == 0 && chessBoard[r][c] != 'B') {
							case1++;
						} else if (((r - i) + (c - j)) % 2 != 0 && chessBoard[r][c] != 'W') {
							case1++;
						}
					}
				}
				for (int r = i; r < i + 8; r++) {
					for (int c = j; c < j + 8; c++) {
						if (((r - i) + (c - j)) % 2 == 0 && chessBoard[r][c] != 'W') {
							case2++;
						} else if (((r - i) + (c - j)) % 2 != 0 && chessBoard[r][c] != 'B') {
							case2++;
						}
					}
				}
				tmpMin = Math.min(case1, case2);
				minCnt = Math.min(tmpMin, minCnt);
			}
		}
		System.out.println(minCnt);
	}
}