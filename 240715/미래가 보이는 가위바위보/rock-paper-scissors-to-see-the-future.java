import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    
    static String c[];
    static int L[], R[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        c = new String[N];

        for(int i=0; i<N; i++){
            c[i] = br.readLine();
        }

        L = new int[N];
        for(String str : new String[]{"P", "H", "S"}){
            int cnt=0;

            for(int i=0; i<N; i++){
                if(c[i].equals(str)) cnt++;

                L[i] = Math.max(L[i], cnt);
            }
        }

        R = new int[N];
        for(String str : new String[]{"P", "H", "S"}){
            int cnt=0;

            for(int i=N-1; i>=0; i--){
                if(c[i].equals(str)) cnt++;

                R[i] = Math.max(R[i], cnt);
            }
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        for(int i=0; i<N-1; i++){
            ans = Math.max(ans, L[i] + R[i+1]);
        }
    }
}