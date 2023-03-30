import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < m; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st2.nextToken());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());

				if (k == 0) {
					union(a, b);
				} else if (k == 1) {
					// a,b가 같은 집합에 포함되어 있는지 확인한다.
					// find(a) == find(b)를 확인한다.
					if (find(a) == find(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// find: a의 부모 노드를 찾는 메서드
	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}

	// union: a와 b를 포함하는 두 집합을 통합하는 연산
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
		// find(b)가 부모 노드가 된다
	}
}