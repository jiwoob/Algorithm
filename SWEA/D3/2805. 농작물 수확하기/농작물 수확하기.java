
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] token = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(token[j]);
				}
			}
			// 최종 결과값
			int sum = 0;

			//열인덱스가 left에서 right 사이인 것만 돌린다.
			int left = N / 2;
			int right = N / 2;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (j <= right && j >= left) {
						sum += arr[i][j];
					}
				}
				if (i < N / 2) {
					left--;
					right++;
				} else {
					left++;
					right--;
				}
			}

			System.out.println("#" + (tc  + 1)+ " " + sum);
		}
	}
}
