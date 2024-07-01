import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=1; i<=m; i++){
            set.add(i);
        }

        int count = 0;

        for(int i=0; i<n; i++){
            Integer x = set.floor(arr[i]);

            if(x==null) break;
            else{
                set.remove(x);
                count++;
            }
        }
        
        System.out.println(count);
    }
}