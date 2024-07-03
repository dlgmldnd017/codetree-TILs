import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int T=1; T<=t; T++){
            int m = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> higher = new PriorityQueue<>(); // higher.peek()를 통해 중앙값 출력 (내림차순)
            PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder()); // (오름차순)

            st = new StringTokenizer(br.readLine());

            higher.add(Integer.parseInt(st.nextToken()));
            sb.append(higher.peek()+" ");

            for(int i=1; i<m; i++){
                int x = Integer.parseInt(st.nextToken());

                if(x > higher.peek()) higher.add(x);
                else lower.add(x);

                if(higher.size()-lower.size()>1) lower.add(higher.poll());
                else if(lower.size() > higher.size()) higher.add(lower.poll());

                if(i%2==0) sb.append(higher.peek()+" ");
            }

            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}