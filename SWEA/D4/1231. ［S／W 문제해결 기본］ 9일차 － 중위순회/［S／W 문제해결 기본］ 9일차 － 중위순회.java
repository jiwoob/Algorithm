import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static String[] tree;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine()); // 노드의 개수

			tree = new String[N + 1]; // N+1 크기의 배열 생성.

			for (int i = 1; i <= N; i++) { // 노드에 문자 입력받기
				StringTokenizer st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			// System.out.println(Arrays.toString(tree));
			System.out.print("#" + tc + " ");
			DFS(1);
			System.out.println();

		}
	}

	// 중위순회 함수
	public static void DFS(int x) {
		if (x <= N) {
			// 왼쪽
			DFS(x * 2);
			// 자기자신
			System.out.print(tree[x]);
			// 오른쪽
			DFS(x * 2 + 1);
		}

	}
}