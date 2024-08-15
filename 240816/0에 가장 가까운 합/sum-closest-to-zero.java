import java.util.*;
import java.io.*;

public class Main {
    static int N, A[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        ans = Integer.MAX_VALUE;

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int j = N;

        for(int i=1; i<=N; i++){
            if(i<j) ans = Math.min(ans, (Math.abs(A[i]+A[j])));
            
            while(i<j-1 && (A[i] + A[j-1]) > 0){
                j--;
                ans = Math.min(ans, (Math.abs(A[i]+A[j])));
            }
        }
    }
}