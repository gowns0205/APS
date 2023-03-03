import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		for (int i = 0; i < 4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			for (int r = y; r < q; r++) {
				for (int c = x; c < p; c++) {
					arr[r][c] = 1;
				}
			}
		}
		int area = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				//System.out.print(arr[r][c] + " ");
				area += arr[r][c];
			}
			//System.out.println();
		}
		System.out.println(area);
	}
}