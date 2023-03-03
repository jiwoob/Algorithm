import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(arr, (o1, o2) -> {
			return o1[0] - o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
		});

		// 최대높이 구하기
		int max = Integer.MIN_VALUE;
		// 최대 높이의 위치 인덱스값.
		int maxIdx = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			if (arr[i][1] > max) {
				max = arr[i][1];
				maxIdx = i;
			}
		}

		// 면적 구하기
		int sum = 1 * max;

		// System.out.println(sum);

		// 왼쪽 탐색
		int leftMaxIdx = maxIdx; // 왼쪽에서 제일 높은 값의 인덱스.
		while (true) {

			int leftMax = Integer.MIN_VALUE; // 왼쪽에서 제일 높은 값 찾기 위해서 사용하는 변수

			int tmpMaxIdx = leftMaxIdx;

			for (int i = 0; i < tmpMaxIdx; i++) {
				if (arr[i][1] > leftMax) {
					leftMax = arr[i][1]; // 가장 높은 값.
					leftMaxIdx = i;
				}
			}

			sum += (arr[tmpMaxIdx][0] - arr[leftMaxIdx][0]) * leftMax;

			if (leftMaxIdx == 0) {
				break;
			}
		}

		// 오른쪽 탐색
		int rightMaxIdx = maxIdx; // 오른쪽에서 제일 높은 값의 인덱스
		while (true) {
			int rightMax = Integer.MIN_VALUE; // 오른쪽에서 제일 높은 높이 찾는 변수

			int tmpMaxIdx = rightMaxIdx;

			for (int i = tmpMaxIdx + 1; i < N; i++) {
				if (arr[i][1] > rightMax) {
					rightMax = arr[i][1];
					rightMaxIdx = i;
				}
			}

			sum += (arr[rightMaxIdx][0] - arr[tmpMaxIdx][0]) * rightMax;

			if (rightMaxIdx == N - 1) {
				break;
			}
		}

		System.out.println(sum);
	}
}