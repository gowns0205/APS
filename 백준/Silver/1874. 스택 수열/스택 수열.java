import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean result = true;
		int cur = 1;
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num >= cur) {
				while (num >= cur) {
					stack.push(cur);
					cur++;
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				if (stack.isEmpty()) {
					result = false;
					continue;
				}
				int top = stack.pop();
				sb.append("-\n");
				if (top > num) {
					result = false;
				}
			}
		}
		if (result)
			System.out.println(sb);
		else
			System.out.println("NO");
		br.close();
	}
}