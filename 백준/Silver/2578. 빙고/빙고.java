import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] bingo = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		int bingoLine = 0;
		int CrossLine1 = 0;
		int CrossLine2 = 0;
		int cnt = 0;
		while (bingoLine + CrossLine1 + CrossLine2 < 3) {
			int num = sc.nextInt();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (bingo[i][j] == num) {
						bingo[i][j] = 0;
						cnt++;
						if (bingo[i][0] == 0 && bingo[i][1] == 0 && bingo[i][2] == 0 && bingo[i][3] == 0
								&& bingo[i][4] == 0)
							bingoLine++;
						if (bingoLine + CrossLine1 + CrossLine2 == 3)
							break;
						if (bingo[0][j] == 0 && bingo[1][j] == 0 && bingo[2][j] == 0 && bingo[3][j] == 0
								&& bingo[4][j] == 0)
							bingoLine++;
						if (bingoLine + CrossLine1 + CrossLine2 == 3)
							break;
						if (bingo[0][0] == 0 && bingo[1][1] == 0 && bingo[2][2] == 0 && bingo[3][3] == 0
								&& bingo[4][4] == 0)
							CrossLine1 = 1;
						if (bingoLine + CrossLine1 + CrossLine2 == 3)
							break;
						if (bingo[0][4] == 0 && bingo[1][3] == 0 && bingo[2][2] == 0 && bingo[3][1] == 0
								&& bingo[4][0] == 0)
							CrossLine2 = 1;
						if (bingoLine + CrossLine1 + CrossLine2 == 3)
							break;
					}
				}
				if (bingoLine + CrossLine1 + CrossLine2 == 3)
					break;
			}

		}
		System.out.println(cnt);
	}
}