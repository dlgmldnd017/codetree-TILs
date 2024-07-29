import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static Map<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            map.put(x1, +1);
            map.put(x2, -1);
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int cnt = 0;

        for(int i : map.values()){
            cnt += i;

            ans = Math.max(ans, cnt);
        }
    }
}