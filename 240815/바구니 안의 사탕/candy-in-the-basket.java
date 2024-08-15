import java.util.*;
import java.io.*;

class Candy implements Comparable<Candy>{
    int x, cnt;

    public Candy(int x, int cnt){
        this.x = x;
        this.cnt = cnt;
    }

    public int compareTo(Candy c){
        return this.x - c.x;
    }
}

public class Main {
    static int N, K, ans;
    static Candy[] candies;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candies = new Candy[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            candies[i] = new Candy(x, cnt);
        }

        Arrays.sort(candies, 1, N+1);

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int j=1, sum=0;

        for(int i=1; i<=N; i++){
            while(j<=N && getXOfCandy(j)-getXOfCandy(i) <= 2*K){
                sum += getCntOfCandy(j);
                j++;
            }

            ans = Math.max(ans, sum);

            sum -= getCntOfCandy(i);
        }
    }

    static int getXOfCandy(int idx){
        return candies[idx].x;
    }

    static int getCntOfCandy(int idx){
        return candies[idx].cnt;
    }
}