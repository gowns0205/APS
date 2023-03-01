import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] swc = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			swc[i] = sc.nextInt();
		}
		int stuN = sc.nextInt();
		int[][] stu = new int[stuN][2];
		for (int i = 0; i < stuN; i++) {
			stu[i][0] = sc.nextInt();// 학생 i의 성별
			stu[i][1] = sc.nextInt();// 학생 i가 받은 수
		}

		for (int i = 0; i < stuN; i++) {
			// 남학생
			if (stu[i][0] == 1) {
				for (int j = 1; j <= N; j++) {
					if (j % stu[i][1] == 0) {
						if (swc[j] == 0)
							swc[j] = 1;
						else
							swc[j] = 0;
					}
				}
			}
			// 여학생
			else {
				for (int k = 0; k <= Math.min(N - stu[i][1], stu[i][1] - 1); k++) {
					if (swc[stu[i][1] - k] == swc[stu[i][1] + k]) {
						if (swc[stu[i][1] - k] == 0) {
							swc[stu[i][1] - k] = 1;
							swc[stu[i][1] + k] = 1;
						} else {
							swc[stu[i][1] - k] = 0;
							swc[stu[i][1] + k] = 0;
						}
					} else {
						break;
					}
				}

			}
		}
		for (int k = 1; k <= N; k++) {
			System.out.print(swc[k]+" ");
			if (k % 20 == 0)
				System.out.println();
		}
	}
}