
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//6485
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int I = 0; I < T; I++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[5001];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for (int j = a; j <= b; j++) {
					arr[j]++;
				}
			}

			int p = Integer.parseInt(br.readLine());
			
			int[] res = new int[p];
			for(int i=0; i<p; i++) {	
				res[i] = arr[Integer.parseInt(br.readLine())];
			}
			
			System.out.print("#" + (I+1) + " ");
			for(int i=0; i<p; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
		}

	}

}