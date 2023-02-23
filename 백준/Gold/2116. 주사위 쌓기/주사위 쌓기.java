import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dice = Integer.parseInt(br.readLine());
		int[][] arr = new int[dice][6];
		for (int i = 0; i < dice; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for (int j = 0; j < 6; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int finalSum = 0;
		int idx = 0;
		while (true) {
			if (idx == 6)
				break;
			int sum = 0;
			int tmpIdx = idx;
			for (int i = 0; i < dice; i++) {
				int max = 0;
				int num = 0;
				if (tmpIdx == 0) {
					num = arr[i][5];
					for (int k = 0; k < 6; k++) {
						if (k != 0 && k != 5)
							max = Math.max(arr[i][k], max);
					}
				} else if (tmpIdx == 1) {
					num = arr[i][3];
					for (int k = 0; k < 6; k++) {
						if (k != 1 && k != 3)
							max = Math.max(arr[i][k], max);
					}
				} else if (tmpIdx == 2) {
					num = arr[i][4];
					for (int k = 0; k < 6; k++) {
						if (k != 2 && k != 4)
							max = Math.max(arr[i][k], max);
					}
				} else if (tmpIdx == 3) {
					num = arr[i][1];
					for (int k = 0; k < 6; k++) {
						if (k != 1 && k != 3)
							max = Math.max(arr[i][k], max);
					}
				} else if (tmpIdx == 4) {
					num = arr[i][2];
					for (int k = 0; k < 6; k++) {
						if (k != 2 && k != 4)
							max = Math.max(arr[i][k], max);
					}
				} else if (tmpIdx == 5) {
					num = arr[i][0];
					for (int k = 0; k < 6; k++) {
						if (k != 0 && k != 5)
							max = Math.max(arr[i][k], max);
					}
				}
				sum += max;
				if (i == dice - 1)
					break;
				else {
					for (int j = 0; j < 6; j++) {
						if (arr[i + 1][j] == num)
							tmpIdx = j;
					}
				}
			}
			finalSum = Math.max(sum, finalSum);
			idx++;
		}
		System.out.println(finalSum);
		br.close();
	}
}