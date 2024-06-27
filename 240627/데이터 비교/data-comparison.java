import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> set = new HashSet<>();

        int n1 = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n1; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int n2 = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n2; i++){
            if(set.contains(Integer.parseInt(st.nextToken()))) sb.append(1+ " ");
            else sb.append(0+" ");
        }

        System.out.println(sb);
    }
}