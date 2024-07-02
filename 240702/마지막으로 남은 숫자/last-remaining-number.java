import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.add(-(Integer.parseInt(st.nextToken())));
        }

        while(pq.size()>=2){
            int x1 = -(pq.poll());
            int x2 = -(pq.poll());

            int y = x1-x2;

            if(y!=0) pq.add(-y);
        }


        if(pq.isEmpty()) sb.append("-1");
        else sb.append(-pq.poll());

        System.out.println(sb);
    }
}