import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int maxSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i != j && j != k && i != k) {
						sum = arr[i] + arr[j] + arr[k];
						if (sum <= M) {
							maxSum = Math.max(sum, maxSum);
						}
					}
				}
			}
		}
		System.out.println(maxSum);
	}

}