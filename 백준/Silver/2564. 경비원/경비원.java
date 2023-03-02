import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		int N = sc.nextInt(); // 상점 개수
		int arr[][] = new int[N + 2][2];
		for (int i = 1; i <= N + 1; i++) {
			arr[i][0] = sc.nextInt(); // 동서남북
			arr[i][1] = sc.nextInt();
		}
		// 동근이의 위치를 행, 열 위치 정보로 변환
		int d_r = 0;
		int d_c = 0;
		if (arr[N + 1][0] == 1) {
			d_r = 0;
			d_c = arr[N + 1][1];
		} else if (arr[N + 1][0] == 2) {
			d_r = height;
			d_c = arr[N + 1][1];
		} else if (arr[N + 1][0] == 3) {
			d_r = arr[N + 1][1];
			d_c = 0;
		} else {
			d_r = arr[N + 1][1];
			d_c = width;
		}
		int sum = 0;
		for (int i = 1; i < N + 1; i++) {
			// 상점의 위치를 행, 열 정보로 변환
			int shop_r = 0;
			int shop_c = 0;
			if (arr[i][0] == 1) {
				shop_r = 0;
				shop_c = arr[i][1];
			} else if (arr[i][0] == 2) {
				shop_r = height;
				shop_c = arr[i][1];
			} else if (arr[i][0] == 3) {
				shop_r = arr[i][1];
				shop_c = 0;
			} else if (arr[i][0] == 4) {
				shop_r = arr[i][1];
				shop_c = width;
			}

			// 시계 방향 탐색
			int cnt_Clock = 0;
			int r = d_r;
			int c = d_c;
			while (shop_r != r || shop_c != c) {
				cnt_Clock++;
//				System.out.println("처음 입력받은 동근 위치 " + d_r + "," + d_c);
//				System.out.println("동근 현재 위치" + r + "," + c);
//				System.out.println("상점 위치 " + shop_r + "," + shop_c);
//				System.out.println();
				if (c != 0 && c != width) {
					if (r == 0)
						c++;
					else
						c--;
				} else if (c == 0 && r != 0) {
					r--;
				} else if (c == 0 && r == 0) {
					c++;
				} else if (c == width && r != height) {
					r++;
				} else if (c == width && r == height) {
					c--;
				}
			}
			//System.out.println("시계 방향 " + cnt_Clock);

			// 반시계 방향 탐색
			int cnt_CounterClock = 0;
			r = d_r;
			c = d_c;
			while (shop_r != r || shop_c != c) {
				cnt_CounterClock++;
				if (c != 0 && c != width) {
					if (r == 0)
						c--;
					else
						c++;
				} else if (c == width && r != 0) {
					r--;
				} else if (c == width && r == 0) {
					c--;
				} else if (c == 0 && r != height) {
					r++;
				} else if (c == 0 && r == height) {
					c++;
				}
			}
			//System.out.println("반시계 방향 " + cnt_CounterClock);
			// 시계와 반시계 중 짧은 루트가 상점 i까지의 최적 루트
			int optimal = Math.min(cnt_Clock, cnt_CounterClock);
			sum += optimal;
		}
		System.out.println(sum);
	}

}