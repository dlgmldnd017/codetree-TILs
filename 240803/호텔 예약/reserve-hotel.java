import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, v;

    public Point(int x, int v){
        this.x = x;
        this.v = v;
    }

    public int compareTo(Point p){
        if(this.x == p.x) return this.v - p.v;
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

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Point(s, +1));
            list.add(new Point(e, -1));
        }

        Collections.sort(list);

        ans = 1;

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int cnt=0;

        for(Point p : list){
            if(p.v == +1){
                cnt++;
            }
            else{
                cnt--;
            }

            if(p.v==1 && cnt>1) ans++;
        }
    }
}