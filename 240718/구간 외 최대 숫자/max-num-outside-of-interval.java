import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, Q, arr[], L[], R[], ans;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        L = new int[N+2];
        R = new int[N+2];

        solve();

        System.out.println(sb);
    }

    static void solve() throws Exception{
        L[1] = arr[1];
        for(int i=2; i<=N; i++){
            L[i] = Math.max(L[i-1], arr[i]);
        }

        R[N] = arr[N];
        for(int i=N-1; i>=1; i--){
            R[i] = Math.max(R[i+1], arr[i]);
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lv = L[a-1];
            int rv = R[b+1];

            if(lv>rv) sb.append(lv+"\n");
            else sb.append(rv+"\n");
        }
    }
}