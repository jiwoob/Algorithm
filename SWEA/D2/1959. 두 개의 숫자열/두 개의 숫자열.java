
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 리스트 2개 선언
			List<Integer> l1 = new ArrayList<>();
			List<Integer> l2 = new ArrayList<>();

			// 리스트에 요소 채워넣기.
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				l1.add(Integer.parseInt(st2.nextToken()));
			}
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				l2.add(Integer.parseInt(st3.nextToken()));
			}

			// 둘을 곱해서 더한 값.
			int sum = 0;

			// 둘을 곱해서 더한 값들을 넣을 리스트 만들기 ->길이는 M-N+1 (어레이로 해도 되겠다 )
			List<Integer> sumList = new ArrayList<>();

			// 위 어레이에서 제일 큰 값이 구해야하는 정답.
			// 최종적으로 구해야하는 변수 - 최대값
			int max = Integer.MIN_VALUE;

			// 일단 둘중 뭐가 더 긴지 판단해야함.
			// 그러고 나서 둘의 곱을 더한 값을 넣은 리스트 만들자.
			if (N < M) {
				// 곱해서 더한 것의 값을 리스트에 채워야돼
				for (int j = 0; j < (M - N + 1); j++) {
					for (int i = 0; i < N; i++) {
						sum += l1.get(i) * l2.get(i);
					}
					sumList.add(sum);
					l2.remove(0);
					sum = 0;
				}
			} else {
				for (int j = 0; j < (N - M + 1); j++) {
					for (int i = 0; i < M; i++) {
						sum += l1.get(i) * l2.get(i);
					}
					sumList.add(sum);
					l1.remove(0);
					sum = 0;
				}

			}

			// 이제 sumlist에서 가장 큰 숫자 찾으면 된다.
			max = Collections.max(sumList); // 이렇게 하면 안 되려나 ?ㅠ

			System.out.println("#" + tc + " " + max);

		}
	}
}
