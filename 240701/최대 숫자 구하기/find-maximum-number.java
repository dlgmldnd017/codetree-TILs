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

        for(int i=1; i<=m; i++){
            set.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());

            set.remove(x);
            sb.append(set.last()+"\n");
        }
        
        System.out.println(sb);
    }
}