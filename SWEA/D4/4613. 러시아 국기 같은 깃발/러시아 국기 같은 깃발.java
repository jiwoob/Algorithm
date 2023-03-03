import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			char[][] map = new char[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				char[] arr = str.toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = arr[j];
				}
			}

			// 최소값 저장할 변수
			int min = Integer.MAX_VALUE;

			// b: 파란색이 시작되는 인덱스
			// r: 빨간색이 시작되는 인덱스.

			for (int b = 1; b <= N - 2; b++) {
				for (int r = b + 1; r <= N - 1; r++) {

					int cnt = 0;

					// w 부분 색칠해야하는 개수 세기
					for (int i = 0; i < b; i++) {
						for (int j = 0; j < M; j++) {
							if (map[i][j] != 'W') {
								cnt++;
							}
						}
					}

					// B 부분 색칠해야하는 개수 세기
					for (int i = b; i < r; i++) {
						for (int j = 0; j < M; j++) {
							if (map[i][j] != 'B') {
								cnt++;
							}
						}
					}

					// R 부분 색칠해야 하는 개수 세기
					for (int i = r; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (map[i][j] != 'R') {
								cnt++;
							}
						}
					}

					if (cnt < min) {
						min = cnt;
					}

				}
			}
			System.out.println("#" + tc + " " + min);
		}

	}
}
