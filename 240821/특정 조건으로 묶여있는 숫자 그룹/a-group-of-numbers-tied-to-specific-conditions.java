import java.util.*;
import java.io.*;

public class Main {
    static int N, K, arr[], L[], R[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, N+1);
        // 1 5 5 9 10 12 14

        solve();

        System.out.println(ans);
    }

    static void solve(){
		L = new int[N+1];

        int maxNum = 0;
        int i = 1;

        for(int j=1; j<=N; j++){
            while(i+1<=j && arr[j]-arr[i] > K) i++;

            maxNum = Math.max(maxNum, j-i+1);

            L[j] = maxNum;
        }

        R = new int[N+1];

        maxNum = 0;
        int j = N;

        for(i=N; i>=1; i--){
            while(j-1>=i && arr[j]-arr[i] > K) j--;

            maxNum = Math.max(maxNum, j-i+1);

            R[i] = maxNum;
        }

        ans = L[N];

        for(i=1; i<N; i++){
            ans = Math.max(ans, L[i] + R[i+1]);
        }
    }
}