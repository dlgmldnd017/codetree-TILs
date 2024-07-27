import java.util.*;
import java.io.*;

public class Main {
    static int N, checked[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        checked = new int[200001];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            checked[x1]++;
            checked[x2]--;
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int cnt=0;

        for(int i=1; i<=200000; i++){
            cnt += checked[i];
            ans = Math.max(ans, cnt);
        }
    }
}