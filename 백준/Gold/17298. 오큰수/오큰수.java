import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		for (int i = 1; i < N; i++) {
			int idx = i - 1;
			// 스택에 현재 인덱스의 값보다 작은 값이 남아있다면 pop
			while (true) {
				if (arr[idx] < arr[i]) {
					arr[idx] = arr[i];
					stack.pop();
					if (!stack.isEmpty()) {
						idx = stack.peek();
					} else
						break;
				} else {
					// i == N-1인데도 아직 스택에 남아있는 인덱스는 오큰수가 없음
					if (i == N - 1)
						arr[idx] = -1;
					break;
				}
			}
			stack.push(i);
		}
		// 스택에 남아있는 인덱스 = 오큰수가 없는 인덱스이므로 -1
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		// StringBuilder 안 쓰고 하나씩 출력하면 시간 초과 발생
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(arr[i] + " ");
		System.out.println(sb);
		br.close();
	}
}
