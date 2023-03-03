import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int maxSize = 0;
		if(num==1) {
			System.out.println(4);
			System.out.println(1+" "+1+" "+0+" "+1);
		}else {
			for (int i = 1; i < num; i++) {
				int idx = 0;
				int N = num;
				ArrayList<Integer> numList = new ArrayList<>();
				numList.add(N);
				while (N >= 0) {
					int tmp = 0;
					if (idx == 0) {
						tmp = numList.get(idx) - i;
					} else {
						tmp = numList.get(idx - 1) - numList.get(idx);
					}
					numList.add(tmp);
					N = tmp;
					idx++;
				}
				maxSize = Math.max(numList.size(), maxSize);
			}
			System.out.println(maxSize-1);
			for (int i = 1; i < num; i++) {
				int idx = 0;
				int N = num;
				ArrayList<Integer> numList = new ArrayList<>();
				numList.add(N);
				// 100 62 38
				while (N >= 0) {
					int tmp = 0;
					if (idx == 0) {
						tmp = numList.get(idx) - i;
					} else {
						tmp = numList.get(idx - 1) - numList.get(idx);
					}
					numList.add(tmp);
					N = tmp;
					idx++;
				}
				if(numList.size()==maxSize) {
					for(int j=0; j<numList.size()-1;j++) {
						System.out.print(numList.get(j)+" ");
					}
					break;
				}
			}
		}
	}
}