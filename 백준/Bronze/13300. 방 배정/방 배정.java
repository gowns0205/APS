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
		int[][] rooms = new int[7][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st2.nextToken());
			int grade = Integer.parseInt(st2.nextToken());
			rooms[grade][sex] += 1;
			//System.out.println(grade + " " + sex);
		}
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			if (rooms[i][0] != 0 && rooms[i][0] % K != 0)
				sum += rooms[i][0] / K + 1;
			else
				sum += rooms[i][0] / K;
			if (rooms[i][1] != 0 && rooms[i][1] % K != 0)
				sum += rooms[i][1] / K + 1;
			else
				sum += rooms[i][1] / K;
		}
		System.out.println(sum);
	}

}