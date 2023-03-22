import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int r = N % H;
			int c = N / H + 1;
			if (r == 0)
				c--;
			String sr = "";
			if (r == 0) {
				sr = Integer.toString(H);
			} else {
				sr = Integer.toString(r);
			}
			String sc = "";
			if (c < 10) {
				sc = Integer.toString(0) + Integer.toString(c);
			} else {
				sc = Integer.toString(c);
			}
			sb.append(sr).append(sc).append("\n");
		}
		System.out.println(sb);
	}
}