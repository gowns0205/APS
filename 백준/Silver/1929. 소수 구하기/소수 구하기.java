import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> pList = new ArrayList<>(); // 현재까지 구한 소수를 담을 리스트
		pList.add(2);
		for (int i = 1; i <= N; i++) {
			boolean isPrime = true;
			if (i == 1)
				continue;
			else if (i == 2 && 2 >= M) {
				sb.append(2 + "\n");
				continue;
			}
			// 100만 이하 소수가 아닌 수는 2부터 소수 167개로 전부 나눌 수 있음
			for (int j = 0; j < Math.min(168, pList.size()); j++) {
				if (i % pList.get(j) == 0) {
					// System.out.println(i + "은 " + pList.get(j) + "으로 나눌 수 있음");
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				pList.add(i);
				// M이 2보다 큰 수일 때, M보다 작은 소수가 리스트에 담기지 않는 걸 고려해야 함 
				// 이를 위해 i=1 부터 모든 소수를 구하되, 현재 소수 i가 M보다 큰 경우에만 출력 
				if (i >= M)
					sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
}
