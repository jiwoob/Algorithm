import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 꼭짓점 중 하나를 기준점으로 삼고.
 * 기준점으로부터 얼마나 떨어져있는지.
 * 시계방향으로 갈 떄 걸리는 거리.
 * 반시계방향으로 갈 때 걸리는 거리. (전체거리 - 위에서 구한 거리)
 * 비교해서 둘 중 작은 걸로 출력.
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n + 1][2];

		for (int i = 0; i < n + 1; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st2.nextToken());
			arr[i][1] = Integer.parseInt(st2.nextToken());
		}

		int[] dist = new int[n + 1]; // 꼭짓점으로부터의 거리 저장.
		for (int i = 0; i < n + 1; i++) {
			if (arr[i][0] == 1) {
				dist[i] = arr[i][1];
			} else if (arr[i][0] == 2) {
				dist[i] = w + h + w - arr[i][1];
			} else if (arr[i][0] == 3) {
				dist[i] = w + h + w + h - arr[i][1];
			} else {
				dist[i] = w + arr[i][1];
			}
		}


		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = Math.abs(dist[n] - dist[i]);
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (res[i] < 2 * w + 2 * h - res[i]) {
				sum += res[i];
			} else {
				sum += 2 * w + 2 * h - res[i];
			}
		}
		System.out.println(sum);

	}
}