import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, B, ans;
    static int[][] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = arr[i][0] + arr[i][1];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[2], b[2]));

        solve();

        System.out.println(ans);
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            int money = B - (arr[i][0] / 2 + arr[i][1]);
            if (money < 0) continue;

            int cnt = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (money >= arr[j][2]) {
                    money -= arr[j][2];
                    cnt++;
                } else break;
            }

            if (ans < cnt) ans = cnt;
        }
    }
}