import java.util.*;
import java.io.*;

public class Main {
    static int K, ans;
    static String str;
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        str = st.nextToken();

        K = Integer.parseInt(st.nextToken());

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int i=0;

        for(int j=0; j<str.length(); j++){
            char c = str.charAt(j);

            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);

            if(map.size() > K) {
                while(true){
                    if(map.get(str.charAt(i))==1) {
                        map.remove(str.charAt(i));
                        i++;
                        break;
                    }
                    else {
                        map.put(str.charAt(i), map.get(str.charAt(i))-1);
                        i++;
                    }
                }
            }

            ans = Math.max(ans, j-i+1);
        }
    }
}