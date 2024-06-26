import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long arr[] = new long[n];
        
        HashMap<Long, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])-1);

            for(int j=0; j<i; j++){
                if(map.containsKey(k-arr[i]-arr[j])) ans += map.get(k-arr[i]-arr[j]);
            }
        }

        System.out.println(ans);
    }
}