import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = Integer.MIN_VALUE;

			// 일단 둘을 곱한 수를 배열로 받기...
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					String num = Integer.toString(arr[i] * arr[j]);

					int[] arr2 = new int[num.length()];
					// 배열 채우기
					for (int n = 0; n < num.length(); n++) {
						arr2[n] = num.charAt(n) - '0';
					}

					// 단조증가 판단
					boolean flag = true;  //디폴트를 단조증가라고 판단.
					for (int k = 0; k < num.length() - 1; k++) {
						if (arr2[k + 1] < arr2[k]) {
							flag = false; // 하나라도 거짓이면 거짓이 된다.
							break;
						}
					}

					if (flag == true) {
						if (max < Integer.parseInt(num)) {
							max = Integer.parseInt(num);
						}
					}

				}
			}

			if (max < 0) {
				max = -1;
			}

			System.out.println("#" + tc + " " + max);

		}

	}
}