import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String s = br.readLine();
		long hash = 0;
		long R = 1;
		long M = 1234567891;
		for (int i = 0; i < s.length(); i++) {
			long num = s.charAt(i) - 'a' + 1;
			// System.out.println("num: " + num);
			hash += (num * R) % M;
			R = (R * 31) % M;
		}
		System.out.println(hash);
	}
}