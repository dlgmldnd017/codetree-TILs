import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Long> map = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            if(map.containsKey(x)) {
                if(map.get(x) > y) map.put(x, y);
            }
            else{
                map.put(x, y);
            } 
        }

        int ans = 0;
        for(Map.Entry<Long, Long> entry : map.entrySet()){
            ans += entry.getValue();
        }

        System.out.println(ans);
    }
}