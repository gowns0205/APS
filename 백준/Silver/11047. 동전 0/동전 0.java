import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int coin = sc.nextInt();
			arr[i] = coin;
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			count += K / arr[N - 1 - i];
			K = K % arr[N - 1 - i];
		}
		System.out.println(count);
	}
}