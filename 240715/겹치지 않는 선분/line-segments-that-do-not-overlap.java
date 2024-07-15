import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x1, x2;

    public Point(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    public int compareTo(Point p){
        return this.x1 - p.x1;
    }
}

public class Main {
    static int N, L[], R[], ans;
    static Point p[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        p = new Point[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            p[i] = new Point(x1, x2);
        }

        Arrays.sort(p, 1, N+1);

        solve();

        System.out.println(ans);
    }

    static void solve(){
        L = new int[N+1];

        L[0] = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            L[i] = Math.max(L[i-1], p[i].x2);
        }

        R = new int[N+1];

        R[N] = p[N].x2;
        for(int i=N-1; i>=1; i--){
            R[i] = Math.min(R[i+1], p[i].x2);
        }

        // < 겹치는 성립 조건 2가지 >
        // 성립 1: x1이 비교할 x1보다 작다면, x2가 비교할 x2보다 커야 한다.
        // 성립 2: x1이 비교할 x1보다 크다면, x2가 비교할 x2보다 작아야 한다.

        // 여기서는 오름차순 정렬로 성립 1로 정의하였다.
        // L은 최댓값, R은 최솟값
        for(int i=1; i<=N; i++){
            // 겹치는 부분이 없다면
            if(L[i] <= p[i].x2 && p[i].x2 <= R[i]) ans++;

            // 예시 A: (3, 9) <-> B: (7, 8)
            // A.x1 < B.x1 && A.x2 > B.x2 --> 겹치는 조건 성립
            // 그러므로,  L과 R을 적절히 이용해서 캐치해야 한다.
        }
    }
}