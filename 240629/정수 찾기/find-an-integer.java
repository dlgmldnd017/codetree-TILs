import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int input = Integer.parseInt(st.nextToken());

            if(set.contains(input)) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }
}