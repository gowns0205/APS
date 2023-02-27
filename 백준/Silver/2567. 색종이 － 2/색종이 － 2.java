import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[101][101];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
					arr[r][c] = 1;
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int perimeter = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (arr[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int r = i + dx[d];
						int c = j + dy[d];
						if(r>=1&&r<=100&&c>=1&&c<=100 && arr[r][c] == 0)
							perimeter++;
						else if(r<1 || r>100 || c<1 || c>100)
							perimeter++;}

					}

				}
			}
		System.out.println(perimeter);

	}

}