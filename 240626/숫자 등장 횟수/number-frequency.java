import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int input = Integer.parseInt(st.nextToken());

            if(map.containsKey(input)) map.put(input, map.get(input) + 1);
            else map.put(input, 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int input = Integer.parseInt(st.nextToken());

            if(!map.containsKey(input)) System.out.print(0 + " ");
            else System.out.print(map.get(input) + " ");
        }
    }
}