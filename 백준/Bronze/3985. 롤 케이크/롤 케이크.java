import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*케이크 길이 +1 만큼의 배열 생성
 * 이미 받으면 1을 넣는다.
 * n명 + 1 만큼의 배열 생성.
 * 케이크 배열이 0일 때만 개수 센다.
 * */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int[] cake = new int[L + 1];
		int[] cnt = new int[N + 1]; // idx의 사람이 실제로 몇개를 먹는지.

		int max1 = Integer.MIN_VALUE; // 가장 많이 받길 기대하는거.
		int maxIdx1 = Integer.MIN_VALUE;

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (b - a + 1 > max1) {
				max1 = b - a + 1;
				maxIdx1 = i;
			}

			for (int j = a; j <= b; j++) {
				if (cake[j] == 0) {
					cnt[i]++;
					cake[j] = 1;
				}
			}
		}

		int max2 = Integer.MIN_VALUE; // 실제로 제일 많이 받는 방청객.
		int maxIdx2 = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			if (cnt[i] > max2) {
				max2 = cnt[i];
				maxIdx2 = i;
			}
		}

		System.out.println(maxIdx1);
		System.out.println(maxIdx2);

	}

}
