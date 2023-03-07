import java.util.Scanner;

public class Main {
	static final int Land = 1, Water = 0;
	static int w;
	static int h;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];

			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int count = 0;

			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (map[r][c] == Land) {
						DFS(r, c);
						++count;
					}
				}

			}

			System.out.println(count);
		}

	}

	public static void DFS(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr <= h - 1 && nc >= 0 && nc <= w - 1) {
				if (map[nr][nc] == Land) {
					map[nr][nc] = Water;
					DFS(nr, nc);
				}
			}

		}

	}

}
