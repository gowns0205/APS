import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		String s = br.readLine();
		int[] arr = new int[s.length()];
		int[] razer = new int[s.length()];
		int[] stick = new int[s.length()];
		int stickNum =0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.add(i);
				arr[i] = 1;
			} else {
				int num = stack.pop();
				if (arr[i - 1] == 1) {
					razer[i] = 1;
				} else {
					stickNum++;
					for (int j = num; j <= i; j++) {
						stick[j] += 1;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (razer[i] == 1) {
				if (stick[i] != 0) {
					cnt += stick[i];
				}
			}
		}
		System.out.println(cnt+stickNum);
	}
}