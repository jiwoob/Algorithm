import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// 손님이 오는 시간의 배열 구하고 오름차순 정렬
			int[] time = new int[n];

			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				time[i] = Integer.parseInt(st2.nextToken());
			}

			Arrays.sort(time);

			// 결과값
			String res = "Possible";

			for (int i = 0; i < n; i++) {
				if (((time[i] / m) * k) - (i + 1) < 0) {
					res = "Impossible";
					break;
				}
			}

			System.out.println("#" + tc  + " " + res);
		}

	}
}