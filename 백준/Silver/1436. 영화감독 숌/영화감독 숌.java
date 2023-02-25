import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 665;
		while (true) {
			num++;
			int[] arr = new int[3];
			int digit = 0;
			int tmpNum = num;
			int idx = 0;
			while (tmpNum != 0) {
				digit = tmpNum % 10;
				if (digit == 6) {
					arr[idx] = 6;
					if (arr[0] == 6 && arr[1] == 6 && arr[2] == 6) {
						cnt++;
						break;
					} else
						idx++;
				} else {
					arr[0] = 0;
					arr[1] = 0;
					arr[2] = 0;
					idx = 0;
				}
				tmpNum /= 10;
			}
			idx = 0;
			if (cnt == N)
				break;
		}
		System.out.println(num);
	}
}