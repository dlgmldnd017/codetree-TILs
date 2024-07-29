import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, v;

    public Point(int x, int v){
        this.x = x;
        this.v = v;
    }

    public int compareTo(Point p){
        return this.x - p.x;
    }
}

public class Main {
    static int N, K, ans;
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int cur = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            if(command.equals("R")){
                list.add(new Point(cur, +1));
                list.add(new Point(cur+x, -1));

                cur += x;
            }
            else{
                list.add(new Point(cur-x, +1));
                list.add(new Point(cur, -1));

                cur -= x;
            }
        }

        Collections.sort(list);

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int cnt = 0, cur = 0;

        for(Point p : list){
            if(cnt>=2 && p.v == -1){
                ans += Math.abs(cur-p.x);
            }

            cnt += p.v;
            cur = p.x;
        }
    }
}