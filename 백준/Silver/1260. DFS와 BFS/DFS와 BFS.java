

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] visited;
	public static ArrayList<Integer>[] graph; // 어레이리스트가 들어가는 배열.
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NMV = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(NMV.nextToken());
		int M = Integer.parseInt(NMV.nextToken());
		int V = Integer.parseInt(NMV.nextToken()); // start

		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb);

	}

	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			int a = q.poll();
			sb.append(a + " ");
			for (int b : graph[a]) {
				if (!visited[b]) {
					q.add(b);
					visited[b] = true;
				}
			}
		}
	}

	private static void dfs(int x) {
		if (!visited[x]) {
			visited[x] = true;
			sb.append(x + " ");
		}
		for (int a : graph[x]) {
			if (!visited[a]) {
				dfs(a);
			}
		}

	}
}