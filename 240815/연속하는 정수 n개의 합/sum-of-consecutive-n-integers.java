import java.util.*;
import java.io.*;

public class Main {
    static int N, M, A[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int i = 1, sum = 0;

        for(int j=1; j<=N; j++){
            while(i<=N && sum<M){
                sum += A[i];
                i++;
            }

            if(sum == M) ans++;

            sum -= A[j];
        }
    }
}