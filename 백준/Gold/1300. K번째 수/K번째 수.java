import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int start = 1;
		int end = k;
		int mid = 0;
		int answer = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			int count = 0; // 현재 중앙값보다 작은 수 개수 
			for (int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}
			// Lower-Bound: 찾고자 하는 값과 같거나 큰 수가 있는 첫 번째 인덱스 찾기
			if (count >= k) {
				end = mid - 1;
				answer = mid;
			}
			if (count < k) {
				start = mid + 1;
			}
		}
		System.out.println(answer);
	}
}