import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] cnt = new int[N + M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					cnt[i + j]++;
				}
			}

			int max = Integer.MIN_VALUE;

			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] > max) {
					max = cnt[i];
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}