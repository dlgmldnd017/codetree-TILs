import java.util.*;
import java.io.*;

public class Main {
    static int N, moveCost[], fillCost[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        moveCost = new int[N-1];

        fillCost = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            moveCost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            fillCost[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int minFillCost = fillCost[0];

        for(int i=0; i<N-1; i++){
            ans += minFillCost * moveCost[i];

            if(minFillCost > fillCost[i+1]) minFillCost = fillCost[i+1];
        }
    }
}