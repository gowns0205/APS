import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int cutOff = (int) Math.round(n * 0.15);
		int sum = 0;
		int idx = 0;
		for (int i = cutOff; i < n - cutOff; i++) {
			sum += arr[i];
			idx++;
		}
		int avg = (int) Math.round((double) sum / idx);
		System.out.println(avg);
	}
}