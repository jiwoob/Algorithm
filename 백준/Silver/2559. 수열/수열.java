import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());
		}

		// System.out.println(Arrays.toString(nums));

		int[] sums = new int[n - k + 1];

		for (int i = 0; i < n - k + 1; i++) {
			int tmpsum = 0;
			for (int j = i; j < i + k; j++) {
				tmpsum += nums[j];
			}
			sums[i] = tmpsum;
		}

	//	System.out.println(Arrays.toString(sums));

		Arrays.sort(sums);
		int res = sums[n - k];

		System.out.println(res);
	}
}