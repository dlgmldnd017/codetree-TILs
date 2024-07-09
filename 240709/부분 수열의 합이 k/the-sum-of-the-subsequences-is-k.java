import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int p[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n; i++){
            p[i] = p[i-1] + arr[i];
        }

        int cnt = 0;

        for(int i=n-1; i>=0; i--){
            if(p[i]==k) cnt++;

            for(int j=0; j<i; j++){
                if(p[i]-p[j] == k) cnt++;
            }
        }

        System.out.println(cnt);
    }
}