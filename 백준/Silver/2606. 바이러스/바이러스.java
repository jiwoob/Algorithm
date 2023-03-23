import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 노드 수
		int M = sc.nextInt(); // 간선 수

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>(); // 초기화
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			graph[a].add(b);
			graph[b].add(a);
		}

		// System.out.println(Arrays.toString(graph));
		cnt = 0;
		dfs(1);
		Arrays.fill(visited, false);
		cnt = 0;
		bfs(1);
		System.out.println(cnt-1);
	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(i);
		visited[i] = true;

		while (!q.isEmpty()) {
			int a = q.poll();
			cnt++;
			for (int x : graph[a]) {
				if (!visited[x]) {
					q.add(x);
					visited[x] = true;
				}
			}
		}
	}

	private static void dfs(int i) {
		//

	}
}