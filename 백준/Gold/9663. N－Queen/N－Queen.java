import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long cnt = 0;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		queen(0);
		System.out.println(cnt);
	}

	private static void queen(int depth) {
		if (depth == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (checkPosition(depth)) {
				queen(depth + 1);
			}
		}
	}

	private static boolean checkPosition(int col) {
		for (int i = 0; i < col; i++) {
			// 지금까지 등장했던 행인지 체크
			if (arr[col] == arr[i]) {
				return false;
			}
			// 대각선 체크 : 행, 열 위치의 차가 같으면 대각선에 위치
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
				return false;
		}
		return true;
	}
}