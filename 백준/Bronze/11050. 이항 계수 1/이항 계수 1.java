import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int nf = 1;
		int kf = 1;
		int n_kf = 1;
		for (int i = 1; i <= N; i++) {
			nf *= i;
		}
		for (int i = 1; i <= K; i++) {
			kf *= i;
		}
		for (int i = 1; i <= N - K; i++) {
			n_kf *= i;
		}
		System.out.println(nf / (kf * n_kf));
	}
}