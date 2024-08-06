import java.util.*;
import java.io.*;

public class Main {
    static int N, S, Arr[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        Arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = Integer.MAX_VALUE;

        solve();

        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    static void solve(){
        long sum = 0;
        int j = 0;

        for(int i=1; i<=N; i++){

            while(j+1<=N && sum<S){
                sum += Arr[j+1];
                j++;
            }

            if(sum<S) break;

            ans = Math.min(ans, j-i+1);

            sum -= Arr[i];
        }
    }
}