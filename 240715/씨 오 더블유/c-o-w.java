import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long L[], R[], ans;

    static String input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        input = br.readLine();

        solve();

        System.out.println(ans);
    }

    static void solve(){
        L = new long[N];
        if(input.charAt(0)=='C') L[0] = 1;

        for(int i=1; i<N; i++){
            L[i] = L[i-1];

            if(input.charAt(i)=='C') L[i] += 1;
        }

        R = new long[N];
        if(input.charAt(N-1)=='W') R[N-1] = 1;

        for(int i=N-2; i>=0; i--){
            R[i] = R[i+1];

            if(input.charAt(i)=='W') R[i] += 1;
        }

        for(int i=1; i<N-1; i++){
            if(input.charAt(i)=='O') ans += (L[i]*R[i]);
        }
    }
}