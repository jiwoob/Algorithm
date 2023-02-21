import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 사용할 변수 초기화
		int[] A = new int[N];
		int start = 0;
		int end = 0;

		// start - 블루레이크기의 최소값.
		// end - 블루레이 크기의 최대값.
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			if (A[i] > start) {
				start = A[i];
			}
			end = end + A[i];
		}

		// 이진탐색
		while (start <= end) {

			int mid = (start + end) / 2;

			int sum = 0;
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				if (sum + A[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum = sum + A[i];
			}

			if (sum != 0) {
				cnt++;
			}

			if (cnt > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		System.out.println(start);

	}
}
