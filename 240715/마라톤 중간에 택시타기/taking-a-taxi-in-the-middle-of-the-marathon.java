import java.util.*;
import java.io.*;

class Point{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, ans;
    static int LX[], LY[], RX[], RY[];
    static Point p[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        p = new Point[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            p[i] = new Point(x, y);
        }

        LX = new int[N+1];
        LY = new int[N+1];
        RX = new int[N+1];
        RY = new int[N+1];

        for(int i=2; i<=N; i++){
            LX[i] = LX[i-1] + Math.abs(p[i].x - p[i-1].x);
            LY[i] = LY[i-1] + Math.abs(p[i].y - p[i-1].y);
        }

        for(int i=N-1; i>=1; i--){
            RX[i] = RX[i+1] + Math.abs(p[i].x - p[i+1].x);
            RY[i] = RY[i+1] + Math.abs(p[i].y - p[i+1].y);
        }

        ans = Integer.MAX_VALUE;
        
        solve();

        System.out.println(ans);
    }

    static void solve(){
        for(int i=2; i<=N-1; i++){
            int XSum = LX[i-1] + RX[i+1] + Math.abs(p[i+1].x - p[i-1].x);
            int YSum = LY[i-1] + RY[i+1] + Math.abs(p[i+1].y - p[i-1].y);

            ans = Math.min(ans, XSum + YSum);
        }
    }
}