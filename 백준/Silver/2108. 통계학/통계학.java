import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cnt = new int[8001];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			cnt[arr[i] + 4000]++;
		}
		Arrays.sort(arr);
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		int mode = 0; // 최빈값
		int max = 0;
		for (int i = 0; i <= 8000; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				mode = i - 4000;
			}
		}
		int findSecondMode = 0; // 최빈값이 여러 개 있을 때는 두 번째 작은 값 출력해야함
		for (int i = 0; i <= 8000; i++) {
			if (cnt[i] == max) {
				findSecondMode++;
			}
			if (findSecondMode == 2) {
				mode = i - 4000;
				break;
			}
		}
		System.out.println(Math.round((double) sum / N));
		System.out.println(arr[N / 2]);
		System.out.println(mode);
		System.out.println(arr[N - 1] - arr[0]);
	}
}