import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int maxAsc = 1;
		int maxDsc = 1;
		int tempAsc = 1;
		int tempDsc = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] <= arr[i]) {
				tempAsc++;
				maxAsc = Math.max(maxAsc, tempAsc);
			} else {
				tempAsc = 1;
			}
			if (arr[i - 1] >= arr[i]) {
				tempDsc++;
				maxDsc = Math.max(maxDsc, tempDsc);
			} else {
				tempDsc = 1;
			}
		}
		System.out.println(Math.max(maxAsc, maxDsc));
		br.close();
	}
}