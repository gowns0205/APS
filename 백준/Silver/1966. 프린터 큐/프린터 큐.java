import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<document> queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int pr = Integer.parseInt(st.nextToken());
				queue.add(new document(i, pr));
			}
			int idx = 1;
			while (true) {
				boolean bl = true;
				document cur = queue.poll();
				for (document d : queue) {
					if (d.priority > cur.priority) {
						bl = false;
					}
				}
				if (bl) {
					if (cur.idx == M) {
						sb.append(idx + "\n");
						break;
					} else
						idx++;
				} else {
					queue.add(cur);
				}
			}
		}
		System.out.println(sb);
	}

	public static class document {
		int idx;
		int priority;

		public document(int idx, int priority) {
			super();
			this.idx = idx;
			this.priority = priority;
		}
	}
}