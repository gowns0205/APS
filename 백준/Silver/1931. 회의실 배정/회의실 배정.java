import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] room = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			room[i] = new Meeting(A, B);
		}
		Arrays.sort(room);
		int max = 1;
		int endTime = room[0].end;
		for (int i = 1; i < N; i++) {
			if (room.length == 1)
				break;
			if (room[i].start >= endTime ) {
				endTime = room[i].end;
				max++;
			}
		}
		System.out.println(max);
	}

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end)
				return this.start - o.start;
			return this.end - o.end;
		}
	}
}