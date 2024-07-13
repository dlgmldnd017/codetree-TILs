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

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(n==1) ans = 2;
        else solve();

        System.out.println(ans);
    }

    static void solve(){
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i=0; i<n; i++){
            
            int cnt = 1;
            int prev = arr[i][0];
        
            // 행 확인
            for(int j=1; j<n; j++){
                if(arr[i][j] == prev) cnt++;
                else {
                    prev = arr[i][j];
                    cnt=1;
                }

                if(cnt==m) {
                    ans++;
                    break;
                }    
            }
            
            cnt = 1;
            prev = arr[0][i];
            // 열 확인
            for(int j=1; j<n; j++){
                if(arr[j][i] == prev) cnt++;
                else {
                    prev = arr[j][i];
                    cnt=1;
                }

                if(cnt==m) {
                    ans++;
                    break;
                }    
            }
        }
    }
}