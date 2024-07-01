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

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            int x = Integer.parseInt(br.readLine());

            if(set.ceiling(x) != null) sb.append(set.ceiling(x)+"\n");
            else sb.append(-1+"\n");
        }
        
        System.out.println(sb);
    }
}