import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double ans = 0.0;

        for(int i=0; i<N-2; i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int sum=0;
            
            for(int j=i+1; j<N; j++){
                pq.add(arr[j]);
                sum += arr[j];
            }

            sum -= pq.poll();

            ans = Math.max(ans, sum/pq.size());
        }
        
        System.out.printf("%.2f", ans);
    }
}