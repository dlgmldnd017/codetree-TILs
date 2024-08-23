import java.util.*;
import java.io.*;

public class Main {
    static int N, M, arr[], ans;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = Integer.MAX_VALUE;

        solve();

        if (ans == Integer.MAX_VALUE) ans = -1;

        System.out.println(ans);
    }

    static void solve() {
        int i = 1;

        for (int j = 1; j <= N; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            while (map.size() == M) {
                ans = Math.min(ans, j - i + 1);

                if (map.get(arr[i]) == 1) map.remove(arr[i]);
                else map.put(arr[i], map.get(arr[i]) - 1);

                i++;
            }

        }
    }
}