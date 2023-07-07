import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int curSize = N;
		int blue = 0;
		int white = 0;
		boolean[][] visited = new boolean[N][N];
		while (curSize > 0) {
			// NxN 색종이부터 크기 1/2 해가면서 찾기
			//System.out.println("현재 사이즈: " + curSize);
			for (int i = 0; i < N; i += curSize) {
				for (int j = 0; j < N; j += curSize) {
					if (visited[i][j])
						continue;
					int start = arr[i][j];
					boolean ok = true;
					// 시작한 위치와 쭉 같은 값이라면 온전한 색종이로 판정
					for (int r = i; r < i + curSize; r++) {
						for (int c = j; c < j + curSize; c++) {
							if (arr[r][c] != start && curSize != 1) {
								ok = false;
								break;
							}
						}
					}
					if (ok) {
						//System.out.println("성공: " + i + " " + j);
						if (start == 0)
							white++;
						else
							blue++;
						// 온전한 색종이로 판정되면 그 부분 전부 방문처리
						for (int r = i; r < i + curSize; r++) {
							for (int c = j; c < j + curSize; c++) {
								visited[r][c] = true;
							}
						}
					}
				}
			}
			curSize /= 2;
		}
		System.out.println(white);
		System.out.println(blue);
	}
}