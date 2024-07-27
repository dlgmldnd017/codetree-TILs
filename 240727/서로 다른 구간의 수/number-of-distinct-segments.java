import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, v, index;

    public Point(int x, int v, int index){
        this.x = x;
        this.v = v;
        this.index = index;
    }

    public int compareTo(Point p){
        return this.x - p.x;
    }
}

public class Main {
    static int N, ans;
    static List<Point> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N;i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Point(a, 1, i));
            list.add(new Point(b, -1, i));
        }

        Collections.sort(list);

        solve();

        System.out.println(ans);
    }

    static void solve(){
        for(int i=0; i<N*2; i++){
            int v = list.get(i).v;
            int index = list.get(i).index;

            if(v == +1){
                if(set.size()==0) ans++;

                set.add(index);
            }
            else{
                set.remove(index);
            }
        }
    }
}