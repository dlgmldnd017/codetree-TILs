import java.util.*;
import java.io.*;

public class Main {
    static int N, arr[], L[], R[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        L = new int[N];
        L[0] = arr[0];

        for(int i=1; i<N; i++){
            L[i] = Math.max(L[i-1], arr[i]);
        }

        R = new int[N];
        R[N-1] = arr[N-1];

        for(int i=N-2; i>=0; i--){
            R[i] = Math.max(R[i+1], arr[i]);
        }

        for(int i=2; i<N-2; i++){
            ans = Math.max(ans, L[i-2] + arr[i] + R[i+2]);
        }
    }
}