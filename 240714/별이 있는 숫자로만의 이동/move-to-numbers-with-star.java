import java.util.*;
import java.io.*;

public class Main {
    static int N, K, ans;
    static int arr[][], prefixSum[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // (1,1) ~ (N, N)만큼의 배열 입력 받기
        arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1차원 누적 합(열) 구하기
        prefixSum = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                prefixSum[i][j] = prefixSum[i][j-1] + arr[i][j];
            }
        }

        // 문제 풀기
        solve();

        System.out.println(ans);
    }

    static void solve(){
        // (1,1) ~ (N, N)까지 중심좌표일 때, 나올 수 있는 합 구하기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                int sum = 0;

                // 이동할 수 있는 행(r) 구하기
                for(int r=i-K; r<=i+K; r++){ // if) i=2 k=1 일때, (1) ~ (3)까지 이동 가능

                    // 이동 할 수 있는 열(c) 구하기
                    int c = K - Math.abs(i-r); 
                    // if1) i=2, r=2일때, K만큼 이동 가능
                    // if2) i=2, r=3일때, K-1만큼 이동 가능

                    if(r>=1 && r<=N) sum += prefixSum[r][Math.min(N, j+c)] - prefixSum[r][Math.max(0, j-c-1)];
                }

                ans = Math.max(ans, sum);
            }
        }
    }
}