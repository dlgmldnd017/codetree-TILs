import java.util.*;
import java.io.*;

public class Main {
    static int n, m, ans;
    static int arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(n==1) ans = 1;
        else solve();
        System.out.println(ans);
    }

    static void solve() {
        for (int i = 0; i < n; i++) {
            // 행 확인
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (cnt == m) {
                    ans++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            // 열 확인
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (cnt == m) {
                    ans++;
                    break;
                }
            }
        }
    }
}