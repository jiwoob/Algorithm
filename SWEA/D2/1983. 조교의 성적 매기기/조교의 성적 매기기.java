import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스만큼 돌리기
		for (int I = 1; I <= T; I++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 학생수만큼 돌리기

			String[] credits = new String[] { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

			// n명의 학생들 점수가 들어가는 어레이 , n개의 총점수 있음. - 테스트 케이스 당 하나.
			Double[] arr = new Double[N];
			String res = ""; // k 번째 학생의 학점이 될 변수. - 테스트 케이스 당 하나.

			for (int i = 0; i < N; i++) {

				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int score1 = Integer.parseInt(st2.nextToken());
				int score2 = Integer.parseInt(st2.nextToken());
				int score3 = Integer.parseInt(st2.nextToken());

				double sum = 0.35 * score1 + 0.45 * score2 + 0.2 * score3;
				arr[i] = sum;
				// arr를 학생들 점수로 채운다.
			}

			double k_score = arr[K - 1]; // k번째 학생의 점수 확보.
			Arrays.sort(arr, Collections.reverseOrder()); // 점수배열 내림차순으로 정렬

			// 어레이 돌면서 k번째 학생의 점수가 몇번째인지 확인.
			for (int j = 0; j < N; j++) {
				if (k_score == arr[j]) {
					res = credits[j / (N / 10)];
					break;
				}
			}

			System.out.println("#" + I + " " + res);

		}
	}
}
