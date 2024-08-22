import java.util.*;
import java.io.*;

public class Main {
    static int N, K, arr[], ans;
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeSet<Integer> set[] = new TreeSet[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
		int i=1;

        for(int j=1; j<=N; j++){
            int tmp = arr[j];
            
            if(map.containsKey(tmp)) map.put(tmp, map.get(tmp)+1);
            else map.put(tmp, 1);
            
            while(map.get(tmp) > K){
                int startValue = arr[i];

                map.put(startValue, map.get(startValue) - 1);

                if (map.get(startValue) == 0) {
                    map.remove(startValue);
                }

                i++;
            }

            ans = Math.max(ans, j-i+1);
        }
    }
}