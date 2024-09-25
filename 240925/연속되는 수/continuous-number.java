import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, A[], ans;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        solve();

        System.out.println(ans);
    }

    static void solve() {
        for (int i = 0; i < N - 1; i++) {
            int targetValue = A[i], curValue = -1, longSeq = 1;

            for (int j = 0; j < N; j++) {
                if(targetValue == A[j]) continue;

                if(curValue == -1) curValue = A[j];
                else{
                    if(curValue == A[j]) longSeq++;
                    else{
                        ans = Math.max(ans, longSeq);
                        curValue = A[j];
                        longSeq=1;
                    }
                }

                ans = Math.max(ans, longSeq);
            }
        }

        if(ans==1) ans = 0;
    }
}