import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());

			// 테스트 케이스마다 큐 생성
			Queue<Integer> q = new LinkedList<Integer>();

			// 큐에 원소 삽입하기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			boolean flag = true;
			while (flag) {

				for (int i = 1; i <= 5; i++) { // 1~5까지 더하는 싸이클
					int tmp = q.peek() - i;
					if (tmp > 0) {
						q.remove();
						q.add(tmp);
					} else if (tmp <= 0) {
						q.remove();
						q.add(0);
						flag = false;
						break;
					}
				}
			}

			// 프린트
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.remove() + " ");
			}
			System.out.println();
		}
	}
}