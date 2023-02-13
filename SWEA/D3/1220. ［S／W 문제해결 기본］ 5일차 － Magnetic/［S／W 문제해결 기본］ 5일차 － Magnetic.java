import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			// num은 어차피 항상 100인데 입력 받아와야해서 받아왔습니다.

			// 2차배열 입력받기
			int[][] arr = new int[num][num];
			for (int i = 0; i < num; i++) {
				String[] token = br.readLine().split(" ");
				for (int j = 0; j < num; j++) {
					arr[i][j] = Integer.parseInt(token[j]);
				}
			}

			int cnt = 0; // 교착 상태를 카운팅.

			for (int i = 0; i < num; i++) {
				int tmp = 0;
				for (int j = 0; j < num; j++) {
					if (arr[j][i] == 1) {  //1을 찾으면
						tmp = 1;  //1 값을 임시적으로 저장해둠.
					}
					if (tmp == 1 && arr[j][i] == 2) { //1이후에 어레이 값이 2이면 된다.
						cnt++; 
						tmp = 0; //지금 tmp ==1 인 상태니까, 다시 초기화해줘야함
					}
				}
			}

			System.out.println("#" + tc + " " + cnt);

			

		}
	}
}