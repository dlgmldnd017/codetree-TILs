import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, v;

    public Point(int x, int v){
        this.x = x;
        this.v = v;
    }

    public int compareTo(Point p){
        return this.x - p.x;
    }
}

public class Main {
    static int N, ans;
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Point(a, +1));
            list.add(new Point(b, -1));
        }

        Collections.sort(list);

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int cnt = 0, cur = 0;

        for(Point p : list){
            if(cnt==0) cur = p.x;

            cnt += p.v;

            if(cnt == 0){
                ans += p.x - cur;
            }
        }
    }
}