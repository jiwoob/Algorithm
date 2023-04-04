import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로탐색
public class Main {
	// 전역변수 선언
	static int N;
	static int M;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		boolean[][] visited = new boolean[N][M];

		System.out.println(bfs(0, 0, map, visited)); // 시작 위치.
	}

	private static int bfs(int x, int y, int[][] map, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];

			if (r == N - 1 && c == M - 1) {
				return map[N - 1][M - 1];
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if ((nr >= 0 && nr <= N - 1 && nc >= 0 && nc <= M - 1) && (!visited[nr][nc]) && map[nr][nc] == 1) {
					visited[r][c] = true;
					q.add(new int[] { nr, nc });
					map[nr][nc] = map[r][c] + 1;
				}
			}

		}
		return 0;
	}

}