import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}
		int save = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j]) {
					save = arr[j];
					arr[j] = arr[i];
					arr[i] = save;
				}
			}
		}
		for (int i : arr)
			System.out.println(i);
	}
}