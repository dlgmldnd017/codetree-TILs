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

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            Integer x = set.floor(Integer.parseInt(st.nextToken()));

            if(x==null) sb.append(-1+"\n");
            else{
                sb.append(x+"\n");
                set.remove(x);
            }
        }
        
        System.out.println(sb);
    }
}