import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int len1 = 1; // 점점 커지는 숫자로 최대 길이
		int len2 = 1; // 점점 줄어드는 숫자로 최대 길이

		int max = 1; // 숫자가 하나일 때 아래 for문들 안 돌아가니까. 입력이 1개일 경우의 max 1로 주고 시작해야함

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				len1++;
			} else
				len1 = 1;
			max = Math.max(max, len1);
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] >= arr[i + 1]) {
				len2++;
			} else
				len2 = 1;
			max = Math.max(max, len2);

		}

		System.out.println(max);
	}
}