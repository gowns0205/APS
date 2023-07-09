import java.util.Scanner;

public class Main {
	static int minCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		minCnt = Integer.MAX_VALUE;
		calculation(N, 0);
		System.out.println(minCnt);
	}

	public static void calculation(int cur, int cnt) {
		// 여태까지 기록된 최소 횟수보다 현재 카운트가 많으면 재귀 종료
		if (cnt > minCnt)
			return;

		if (cur == 1) {
			if (cnt < minCnt)
				minCnt = cnt;
			return;
		} else if (cur < 1) {
			return;
		}

		if (cur % 3 == 0) {
			calculation(cur / 3, cnt + 1);
		}
		if (cur % 2 == 0) {
			calculation(cur / 2, cnt + 1);
		}
		calculation(cur - 1, cnt + 1);
	}
}