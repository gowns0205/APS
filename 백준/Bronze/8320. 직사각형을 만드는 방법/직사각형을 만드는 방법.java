import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			for (int j = i; j <= n; j++) {
				if (i * j <= n) {
					cnt++;
					// System.out.println(i+","+j);
				} else {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}