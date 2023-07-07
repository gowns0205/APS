import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int min = 257;
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (min > map[i][j])
					min = map[i][j];
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		int height = 0;
		int resultTime = Integer.MAX_VALUE;
		// h : 현재 높이
		// 기록 된 최소 높이부터 최대 높이까지 전부 평평하게 만들어보면서
		// 최소 시간과 그에 따른 최대 높이를 찾는다. 
		for (int h = min; h <= max; h++) {
			int block = B;
			int time = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] < h) {
						block -= h - map[i][j];
						time += h - map[i][j];
					} else if (map[i][j] > h) {
						block += map[i][j] - h;
						time += 2 * (map[i][j] - h);
					}
				}
			}
			// 시간이 같을때도 더 높이가 높은 값으로 결과를 업데이트 해줬어야 되는데 
			// 그러지 못해서 틀리고 있었다.
			if (time <= resultTime && block >= 0) {
				resultTime = time;
				height = h;
			}
		}
		System.out.println(resultTime + " " + height);
	}
}
