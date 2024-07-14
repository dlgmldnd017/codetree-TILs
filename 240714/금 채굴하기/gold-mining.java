import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans;
    static int arr[][], prefixSum[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합
        prefixSum = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                prefixSum[i][j] = prefixSum[i][j-1] + arr[i][j];
            }
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        for(int k=0; k<=N; k++){

            // 중심 좌표
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    // 값
                    int sum = 0;

                    // 행
                    for(int r=i-k; r<=i+k; r++){
                        int c = k-Math.abs(i-r);

                        if(r>=1 && r<=N){
                            sum += prefixSum[r][Math.min(N, j+c)] - prefixSum[r][Math.max(0, j-c-1)];
                        }
                    }

                    int cnt = sum;
                    sum *= M;

                    if(getCalcK(k)<=sum) ans = Math.max(ans, cnt);
                }
            }
        }
    }

    // 채굴에 드는 비용
    static int getCalcK(int k){
        return k*k+(k+1)*(k+1);
    }
}