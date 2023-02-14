
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int sum = 0; // result

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열 입력받기
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int[] multifly = new int[n];
		for (int i = n; i >= 1; i--) {
			multifly[n - i] = i;
		}

		for (int i = 0; i < n; i++) {
			sum += arr[i] * multifly[i];
		}

		System.out.println(sum);

	}

}
