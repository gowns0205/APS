import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][3];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = Integer.toString(i);
			arr[i][2] = st.nextToken();
		}

		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				int age1 = Integer.parseInt(s1[0]);
				int age2 = Integer.parseInt(s2[0]);
				int seq1 = Integer.parseInt(s1[1]);
				int seq2 = Integer.parseInt(s2[1]);
				if (age1 == age2)
					return seq1 - seq2; // 나이 같다면 가입 먼저한 사람을 앞으로 정렬
				else
					return age1 - age2; // 나이 다르면 어린 사람을 앞으로 정렬

			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0] + " " + arr[i][2] + "\n");
		}
		System.out.println(sb);
	}
}