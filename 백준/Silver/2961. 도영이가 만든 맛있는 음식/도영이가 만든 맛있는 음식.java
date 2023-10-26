import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long minDiff;
	static int[] sour, bitter;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		minDiff = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		DFS(0, 1, 0);
		System.out.println(minDiff);
	}

	static void DFS(int depth, long sourMuti, long bitterSum) {
		if (depth > 0 && bitterSum > 0) {
//			System.out.println(sourMuti + " , " + bitterSum);
			long curDiff = Math.abs(sourMuti - bitterSum);
			if (curDiff < minDiff)
				minDiff = curDiff;
		}
		if (depth == N) {
			return;
		}
		DFS(depth + 1, sourMuti * sour[depth], bitterSum + bitter[depth]);
		DFS(depth + 1, sourMuti, bitterSum);
	}
}