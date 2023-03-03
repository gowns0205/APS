import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxH = -1;
		int sum = 0;
		ArrayList<Integer> maxList = new ArrayList<>();
		int[][] pillar = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			pillar[i][0] = L;
			pillar[i][1] = H;
			if (H > maxH) {
				maxH = H;
			}
		}
		for (int i = 0; i < N; i++) {
			if (pillar[i][1] == maxH)
				maxList.add(pillar[i][0]); // 최대 높이 기둥의 열 정보 저장
		}
		Collections.sort(maxList); // 최대 높이 기둥 리스트 오름차순 정렬
		if (maxList.size() == 1)
			sum += maxH;
		else
			sum += (maxList.get(maxList.size() - 1) - maxList.get(0)+1) * maxH;

		// 2차원 배열 정렬
		Arrays.sort(pillar, (o1, o2) -> {
			return o1[0] - o2[0]; // 첫번째 숫자=pillar[i][0] 기준 오름차순 정렬
		});

		int tmpMax = 0;
		int idx = 0;
		for (int i = pillar[0][0]; i <= pillar[N - 1][0]; i++) {
			if (i == maxList.get(0))
				break;
			else {
				if (i == pillar[idx + 1][0])
					idx++;
				tmpMax = Math.max(pillar[idx][1], tmpMax);
				//System.out.println(tmpMax + " " + i);
				sum += tmpMax;
			}
		}
		tmpMax = 0;
		idx = N - 1;
		for (int i = pillar[N - 1][0]; i >= pillar[0][0]; i--) {
			if (i == maxList.get(maxList.size() - 1))
				break;
			else {
				if (i == pillar[idx - 1][0])
					idx--;
				tmpMax = Math.max(pillar[idx][1], tmpMax);
				//System.out.println(tmpMax + " " + i);
				sum += tmpMax;
			}
		}
		System.out.println(sum);
	}
}