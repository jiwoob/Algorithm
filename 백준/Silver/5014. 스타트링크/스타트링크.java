import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int F, S, G, U, D, cnt;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		visited = new boolean[F + 1];
		cnt = 0;
		if (S == G) {
			System.out.println(0);
		} else {
			bfs(new Node(S, 0));
			System.out.println(cnt == 0 ? "use the stairs" : cnt);
		}
	}
	// dfs는 거의 무족껀 void로

	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node a = queue.poll();

			if (a.a == G) {
				cnt = a.b;
				return;
			}

			if (!visited[a.a]) {
				visited[a.a] = true;
				if ((a.a + U <= F) && !visited[a.a + U] && U != 0) {
					queue.add(new Node(a.a + U, a.b + 1));
					// visited[a+U]=true;
				}
				if ((a.a - D >= 1) && !visited[a.a - D] && D != 0) {
					queue.add(new Node(a.a - D, a.b + 1));
					// visited[a-D]=true;
				}
			}
		}
	}

	static class Node {
		int a;
		int b;

		public Node(int a, int b) {

			this.a = a;
			this.b = b;
		}

	}
}