
import java.util.Scanner;

//1986
public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++) {
			int n = sc.nextInt();
			int sum =0;
			for(int j=1; j<=n; j++) {
				if(j%2==0) {
					sum -= j;
				}
				else if(j%2==1) {
					sum += j;
				}
			}
			
			System.out.println("#" + (i+1) + " " + sum);
		}
		
	}
}
