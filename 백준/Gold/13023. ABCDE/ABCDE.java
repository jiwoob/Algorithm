import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//ABCDE
public class Main {
	// 전역변수 선언
	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int cnt;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N]; // 노드 개수만큼 길이 지정
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>(); // 그래프 초기화 해줘야함.
		}

		// 그래프 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		flag = false;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, 0);
			if (flag) {
				System.out.println(1);
				break;
			} 
		}if(flag == false) {
			System.out.println(0);
		}
		

	}

	private static void dfs(int x, int depth) {
		if (depth == 4) {
			flag = true;
			return;
		}
		for (int a : graph[x]) {
			if (!visited[a]) {
				visited[a] = true;
				dfs(a, depth + 1);
				visited[a] = false;
			}
		}
	}
}