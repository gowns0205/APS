import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int pair = 0;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println(twoPointers(arr, X));
	}

	private static int twoPointers(int[] arr, int x) {
		int left = 0;
		int right = N - 1;
		while (left < right) {
			if (arr[left] + arr[right] == x) {
				pair++;
				right--;
			} else if (arr[left] + arr[right] < x) {
				left++;
			} else {
				right--;
			}
		}
		return pair;
	}
}