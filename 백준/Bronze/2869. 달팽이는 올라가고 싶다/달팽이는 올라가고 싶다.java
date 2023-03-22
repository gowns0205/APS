import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int height = 0;
		if (A == V)
			System.out.println(1);
		else {
			// float은 부동 소수점 오차때문에 값 달라짐
			double tmp = (double) (V - A) / (A - B);
			int eve = (int) Math.ceil(tmp);
			System.out.println(eve + 1);
		}
	}
}