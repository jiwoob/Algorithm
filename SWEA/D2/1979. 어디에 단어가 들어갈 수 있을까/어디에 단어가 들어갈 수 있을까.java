
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1979

public class Solution {
	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // n*n
			int k = Integer.parseInt(st.nextToken()); // 단어의 길이 k

			// 배열 입력받기
			int[][] arr = new int[n+1][n+1];
			for (int r = 0; r < n; r++) {
				String[] token = br.readLine().split(" ");
				for (int c = 0; c < n; c++) {
					arr[r][c] = Integer.parseInt(token[c]);
				}
			}

			// row
			int cnt1 = 0;
			int res = 0; // 결과값.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						cnt1++;
					} else {
						cnt1 = 0;
					}
					if (cnt1 == k && (arr[i][j + 1] == 0 || j == n - 1)) {
						res++;
						cnt1 = 0;
					}

				}
				cnt1 = 0;

			}

			// column
			int cnt2 = 0;
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					if (arr[i][j] == 1) {
						cnt2++;
					} else {
						cnt2 = 0;
					}
					if (cnt2 == k & (arr[i + 1][j] == 0 || i == n - 1)) {
						res++;
						cnt2 = 0;
					}
				}
				cnt2 = 0;
			}

			System.out.println("#" + tc + " " + res);
		}

	}

}
