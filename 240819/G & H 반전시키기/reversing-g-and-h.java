import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static String init, target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        init = br.readLine();
        target = br.readLine();

        solve();

        System.out.println(ans);
    }

    static void solve(){
        boolean inSegment = false;

        for(int i=0; i<N; i++){
            if(init.charAt(i) != target.charAt(i)){
                if(!inSegment){
                    ans++;
                    inSegment = true;
                }
            }
            else{
                inSegment = false;
            }
        }
    }
}