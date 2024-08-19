import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point p){
        return this.x - p.x;
    }
}

class TargetPoint implements Comparable<TargetPoint> {
    int x, y;

    public TargetPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(TargetPoint p) {
        if(this.y != p.y)
            return this.y - p.y;            
        return this.x - p.x;                   
    }
}

public class Main {
    static int N, D, ans;
    static Point p[];
    static TreeSet<TargetPoint> pCnt = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        p = new Point[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            p[i] = new Point(x, y);
        }

        ans = Integer.MAX_VALUE;

        Arrays.sort(p, 1, N+1);

        solve();

        if(ans == Integer.MAX_VALUE) ans = -1;
        
        System.out.println(ans);
    }

    static void solve(){
        int j=0;

        for(int i=1; i<=N; i++){
            while(j+1<=N && getMax() - getMin() < D){
                pCnt.add(new TargetPoint(p[j+1].x, p[j+1].y));
                j++;
            }
            
            if(getMax() - getMin() < D) break;

            ans = Math.min(ans, p[j].x - p[i].x);

            pCnt.remove(new TargetPoint(p[i].x, p[i].y));
        }
    }

    static int getMin(){
        if(pCnt.isEmpty()) return 0;

        return pCnt.first().y;
    }

    static int getMax(){
        if(pCnt.isEmpty()) return 0;

        return pCnt.last().y;
    }
}