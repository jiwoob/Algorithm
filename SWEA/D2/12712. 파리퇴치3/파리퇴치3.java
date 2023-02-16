
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*+모양의 합 -> dr dc 이용해서 for문 돌리기
 * x 모양의 합도 같은 방식으로 돌리기
 * 인덱스를 벗어나지 않는 범위에서 돌리기 위한 조건 있어야 함.
 * 최대값 고르기
 * */

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[] dr2 = { -1, 1, -1, 1 };
	static int[] dc2 = { -1, -1, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][n];

			// 배열 입력 받기
			for (int i = 0; i < n; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st1.nextToken());
				}
			}

			// 최대값, 합 변수 2가지 필요
			int max = 0;

			int sum = 0;

			// 행렬 일단 전부 순회.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 십자가 중에서 최대값 찾기
					sum = 0;
					sum += arr[i][j];

					for (int d = 0; d < 4; d++) { // 4방 탐색해서 합.
						for (int k = 1; k < m; k++) {
							int nr = i + dr[d] * k;
							int nc = j + dc[d] * k;

							if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= n - 1)
								sum += arr[nr][nc];
						}
					}
					if (sum > max)
						max = sum;

					// 엑스표 중에서 최대값 찾기
					sum = 0;
					sum += arr[i][j];

					for (int d = 0; d < 4; d++) { // 4방 탐색해서 합.
						for (int k = 1; k < m; k++) {
							int nr = i + dr2[d] * k;
							int nc = j + dc2[d] * k;

							if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= n - 1)
								sum += arr[nr][nc];
						}
					}
					if (sum > max)
						max = sum;

				}
			}

			System.out.println("#" + tc + " " + max);
		}

	}
}