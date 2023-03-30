import java.util.*;
import java.io.*;
 
public class Solution {
    static int N;
    static int[] arr;
    static double[] X, Y;
    static double E;
    static ArrayList<edge> edges;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            for (int i = 0; i <= N; i++)
                arr[i] = i;
             
            X = new double[N];
            Y = new double[N];
            edges = new ArrayList<>();
            StringTokenizer Xs = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                X[i] = Double.parseDouble(Xs.nextToken());
            StringTokenizer Ys = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                Y[i] = Double.parseDouble(Ys.nextToken());
            E = Double.parseDouble(br.readLine());
            for (int i = 0; i < N; i++) {
                double[] I1 = {X[i], Y[i]}; 
                for (int j = i+1; j < N; j++) {
                    double[] I2 = {X[j], Y[j]};
                    edges.add(new edge(i, j, getDistance(I1, I2)));
                }
            }
            Collections.sort(edges);
            int cnt = 0;
            double ans = 0;
            for (edge e : edges) {
                if (cnt == N-1) break;
                if (find(e.s) != find(e.e)) {
                    union(e.s, e.e);
                    cnt++;
                    ans += e.dist;
                }
            }
            sb.append("#"+t+" "+Math.round(ans*E)+"\n");
        }
        System.out.println(sb);
    }
     
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) arr[b] = a;
    }
 
    private static int find(int a) {
        if (a == arr[a]) return a;
        return arr[a] = find(arr[a]);
    }
 
    private static double getDistance(double[] i1, double[] i2) {
        return Math.pow(i1[0]- i2[0], 2) + Math.pow(i1[1]- i2[1], 2);
    }
     
    static class edge implements Comparable<edge>{
        int s;
        int e;
        double dist;
         
        public edge(int s, int e, double dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
 
        @Override
        public int compareTo(edge o) {
            if (this.dist < o.dist) return -1;
            return 1;
        }
    }
}