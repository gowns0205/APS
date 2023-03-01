import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int maxLabel = 0;
		int cnt = 0;
		int num = 1;
		while (cnt < N) {
			boolean label = true;
			int tmpNum = num;
			while (tmpNum != 0) {
				int digit = tmpNum % 10;
				if (digit == L) {
					label = false;
					break;
				}
				tmpNum /= 10;
			}
			if (label) {
				cnt++;
				maxLabel = Math.max(num, maxLabel);
			}
			num++;
		}
		System.out.println(maxLabel);
	}
}