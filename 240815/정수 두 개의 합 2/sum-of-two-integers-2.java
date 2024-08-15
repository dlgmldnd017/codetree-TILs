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

        Arrays.sort(A);

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int j = N;

        for(int i=1; i<=N; i++){
            while(j!=1 && (A[i] + A[j]) > K) j--;

            if(j <= i) break;

            ans += j-i;
        }
    }
}