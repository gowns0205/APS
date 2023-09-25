import java.util.*;
import java.io.*;

// 선택정렬
// 최솟값 또는 최댓값을 찾고, 남은 정렬 부분의 가장 앞에 있는 데이터와 swap
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int len = str.length();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		int idx = 0; // 선택정렬 현재 인덱스
		while (idx < len) {
			int max = -1;
			int maxIdx = -1;
			for (int i = idx; i < len; i++) {
				if(arr[i]>max) {
					max = arr[i];
					maxIdx = i;
				}
			}
			arr[maxIdx] = arr[idx];
			arr[idx] = max;
			idx++;
		}
		for(int i:arr)
			System.out.print(i);
	}
}