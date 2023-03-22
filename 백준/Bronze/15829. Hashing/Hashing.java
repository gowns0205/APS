import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String s = br.readLine();
		long hash = 0;
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 'a' + 1;
			hash += num * Math.pow(31, i);
		}
		System.out.println(hash);
	}
}