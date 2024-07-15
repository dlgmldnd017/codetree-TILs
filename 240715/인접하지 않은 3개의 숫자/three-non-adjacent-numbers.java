import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static int arr[], dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        dp = new int[5][N+1];

        dp[1][1] = arr[1];

        for(int i=1; i<=3; i++){
            for(int j=2*i-1; j<=N; j++){
                if(j<2){
                    dp[i][j] = arr[j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-2] + arr[j]);
            }
        }

        ans = dp[3][N];
    }
}