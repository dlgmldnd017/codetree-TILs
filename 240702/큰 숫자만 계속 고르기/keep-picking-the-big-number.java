import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.add(-(Integer.parseInt(st.nextToken())));
        }

        for(int i=0; i<m; i++){
            int x = -pq.poll();

            x -= 1;

            pq.add(-x);
        }
        
        System.out.println(-pq.poll());
    }
}