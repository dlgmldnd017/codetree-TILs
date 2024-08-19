import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static char c1[], c2[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        N = Integer.parseInt(br.readLine());

        c1 = new char[N+1];
        c2 = new char[N+1];

        str = br.readLine();
        for(int i=1; i<=N; i++){
            c1[i] = str.charAt(i-1);
        }

        str = br.readLine();
        for(int i=1; i<=N; i++){
            c2[i] = str.charAt(i-1);
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        boolean isChanged = false;
        char c = 'G';

		while(true){    
            for(int i=1; i<=N; i++){
                if(c1[i] == c2[i]) continue;

                if(c1[i] == c) {
                    isChanged = true;
                    c1[i] = c2[i];
                }
            }

            if(isChanged) {
                ans++;
                isChanged = false;
            }

            c = c=='G'? 'H' : 'G';

            if(check()) break;
        }
    }

    static boolean check(){
        for(int i=1; i<=N; i++){
            if(c1[i] != c2[i]) return false;
        }

        return true;
    }
}