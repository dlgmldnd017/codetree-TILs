import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, v, index;

    public Point(int x, int v, int index){
        this.x = x;
        this.v = v;
        this.index = index;
    }

    public int compareTo(Point p){
        return this.x - p.x;
    }
}

public class Main {
    static int N, ans[];
    static boolean visited[];
    static List<Point> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ans = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            list.add(new Point(p, +1, i));
            list.add(new Point(q, -1, i));
        }

        Collections.sort(list);

        solve();

        for(int i=1; i<=N; i++){
            sb.append(ans[i]+" ");
        }

        System.out.println(sb);
    }

    static void solve(){
        int cnt = 1;

        for(Point p : list){
            if(p.v == -1){
                visited[ans[p.index]] = false;
            }
            else{
                for(int i=1; i<=N; i++){
                   if(!visited[i]){
                       visited[i] = true;
                       cnt = i;
                       break;
                   }
                }

                ans[p.index] = cnt;
            }
        }
    }
}