import java.util.*;
import java.io.*;

public class Main {
    static int N, K, A[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N+1];

        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int i = 2;

        for(int j=1; j<=N; j++){
            while(i<=N && (A[i] + A[j]) > K){
                i++;
            }

            if(i<=N && (A[i] + A[j]) <= K) ans++;
        }
    }
}