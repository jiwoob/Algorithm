import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			int n = Integer.parseInt(br.readLine());

			char[][] arr = new char[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				char[] arr1 = str.toCharArray();
				for (int j = 0; j < n; j++) {
					arr[i][j] = arr1[j];
				}
			}

			// 5개 셀 변수
			int cnt;

			// 디폴트로 결과는 NO -> 하나라도 성공하면 YES
			String res = "NO";

			// 8방 탐색
			int[] dr = { -1, -1, 1, 1, 0, 0, -1, 1 };
			int[] dc = { 1, -1, 1, -1, 1, -1, 0, 0 };

			// 1점마다 검증, 어레이를 전부 돈다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					// o인 점을 일단 찾아서,
					if (arr[i][j] == 'o') {
						for (int d = 0; d < 8; d++) { // 팔방으로 돌리는데
							cnt = 1; // 8번 돌릴 때 시작마다 cnt 1로 초기화.
							for (int l = 1; l < 5; l++) { // 각 방향으로 다섯개씩 돌려본다.

								int nr = i + dr[d] * l;
								int nc = j + dc[d] * l;
								// System.out.println(nr);

								// 경계를 넘어갈 수도 있으니까 경계를 넘어가지 않을 때만 카운트 올려줘야 함.
								if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= n - 1) {
									if (arr[nr][nc] == 'o') {
										cnt++;
									//	System.out.println(cnt);
									}
								}

							}
							// 5개 돌리는거 끝나고.
							if (cnt == 5) {
								res = "YES";
								break;

							}

						}

					}

				}
			}

			System.out.println("#" + tc + " " + res);

		}

	}
}