import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, restCnt[], LDRMax, MBRMax;
    static long ans;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        restCnt = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int peoCnt = Integer.parseInt(st.nextToken());

            restCnt[i] = peoCnt;
        }

        st = new StringTokenizer(br.readLine());
        LDRMax = Integer.parseInt(st.nextToken());
        MBRMax = Integer.parseInt(st.nextToken());

        solve();

        System.out.println(ans);
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            restCnt[i] -= LDRMax;
            ans++;

            if (restCnt[i] <= 0) continue;
            else {
                int quotient = restCnt[i] / MBRMax;

                if (quotient == 0) ans++;
                else {
                    int remainder = restCnt[i] % MBRMax;

                    if (remainder == 0) ans += quotient;
                    else ans += quotient + 1;
                }
            }
        }
    }
}