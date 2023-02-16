
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2001

public class Solution{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
		int[][] map = new int[n][n];

        	for(int r=0; r<n; r++) {
        		String[] token = br.readLine().split(" ");
        		for(int c=0; c<n; c++) {
					map [r][c] = Integer.parseInt(token[c]);
        		}
        	}
        
        	int max=0;
       for(int a=0; a<n-m+1; a++) {
    	   for(int b=0; b<n-m+1; b++) {    		
    		   int sum = 0;
    		   for(int c=0; c<m; c++) {
    			   for(int d=0; d<m; d++) {
    				   sum += map[a+c][b+d]; 
    				   if(sum>max) {
    					   max=sum;
    			   }
    		   }
    		   
    		 }
    	   }
       }
        	System.out.printf("#%d %d", (i+1), max);
        	System.out.println();
        	
          }
    }
}