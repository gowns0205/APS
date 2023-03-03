import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer wh = new StringTokenizer(br.readLine());
		long w = Long.parseLong(wh.nextToken());
		long h = Long.parseLong(wh.nextToken());
		StringTokenizer pq = new StringTokenizer(br.readLine());
		long p = Long.parseLong(pq.nextToken());
		long q = Long.parseLong(pq.nextToken());
		long t = Long.parseLong(br.readLine());
		
		long P = p + t;
		long Q = q + t;
		if ((P/w)%2 == 0) 
			sb.append(P%w+" ");
		else sb.append((w - (P%w))+" ");
		
		if ((Q/h)%2 == 0)
			sb.append(Q%h+" ");
		else sb.append(h - (Q%h));
		
		System.out.println(sb);
	}
}