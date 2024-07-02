import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0; i<=n; i++){
            set.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            set.remove(Integer.parseInt(st.nextToken()));

            int maxLength = 1;
            int cnt = 1;
            Integer prev = null;

            for(Integer num : set){
                if(prev != null && num == prev+1) cnt++;
                else cnt = 1;

                maxLength = Math.max(maxLength, cnt);
                prev = num;
            }

            sb.append(maxLength+"\n");
        }
        
        System.out.println(sb);
    }
}