import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cham = sc.nextInt();
		int[][] arr = new int[6][2];
		for (int i = 0; i < 6; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int area_big = 0; // ㄱ자 밭에서 넓은 면적
		for (int i = 0; i < 6; i++) {
			area_big = Math.max(arr[i % 6][1] * arr[(i + 1) % 6][1], area_big);
		}

		int area_small = Integer.MAX_VALUE; // ㄱ자 밭에서 좁은 면적
		for (int i = 0; i < 6; i++) {
			if (arr[i % 6][0] == 1 && arr[(i + 1) % 6][0] == 3) {
				area_small = Math.min(arr[i % 6][1] * arr[(i + 1) % 6][1], area_small);
			} else if (arr[i % 6][0] == 3 && arr[(i + 1) % 6][0] == 2) {
				area_small = Math.min(arr[i % 6][1] * arr[(i + 1) % 6][1], area_small);
			} else if (arr[i % 6][0] == 4 && arr[(i + 1) % 6][0] == 1) {
				area_small = Math.min(arr[i % 6][1] * arr[(i + 1) % 6][1], area_small);
			} else if (arr[i % 6][0] == 2 && arr[(i + 1) % 6][0] == 4) {
				area_small = Math.min(arr[i % 6][1] * arr[(i + 1) % 6][1], area_small);
			}
		}
		System.out.println((area_big - area_small) * cham);
	}
}