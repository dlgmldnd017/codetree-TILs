import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static String str;
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        N = str.length();

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int i=0;

        for(int j=0; j<N; j++){
            char c = str.charAt(j);

            if(map.containsKey(c)) i = Math.max(i, map.get(c)+1);

            map.put(c, j);

            ans = Math.max(ans, j-i+1);
        }
    }
}